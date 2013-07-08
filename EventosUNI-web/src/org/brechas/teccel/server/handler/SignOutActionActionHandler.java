package org.brechas.teccel.server.handler;

import static org.brechas.teccel.server.objectify.OfyService.ofy;

import org.brechas.teccel.client.action.SignOutAction;
import org.brechas.teccel.client.action.SignOutActionResult;
import org.brechas.teccel.server.entity.CurrentUser;

import com.google.inject.Inject;
import com.googlecode.objectify.NotFoundException;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class SignOutActionActionHandler implements
		ActionHandler<SignOutAction, SignOutActionResult> {

	@Inject
	public SignOutActionActionHandler() {
	}

	@Override
	public SignOutActionResult execute(SignOutAction action,
			ExecutionContext context) throws ActionException {
		CurrentUser user;
		try {
				user = ofy().load().type(CurrentUser.class)
						.filter("email", action.getEmail()).first().safe();
				user.setIsLoggedin(false);
				ofy().save().entity(user);
				return new SignOutActionResult();
			} catch (NotFoundException e) {
				throw new ActionException(e+"//"+action.getEmail());
			}
	}

	@Override
	public void undo(SignOutAction action, SignOutActionResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<SignOutAction> getActionType() {
		return SignOutAction.class;
	}
}
