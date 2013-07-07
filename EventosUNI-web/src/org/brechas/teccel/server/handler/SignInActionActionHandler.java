package org.brechas.teccel.server.handler;

import static org.brechas.teccel.server.objectify.OfyService.ofy;

import java.util.Date;
import java.util.UUID;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import org.brechas.teccel.client.action.SignInAction;
import org.brechas.teccel.client.action.SignInActionResult;
import org.brechas.teccel.server.entity.CurrentUser;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.Inject;
import com.googlecode.objectify.NotFoundException;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class SignInActionActionHandler implements
		ActionHandler<SignInAction, SignInActionResult> {

	CurrentUser user = new CurrentUser();

	@Inject
	public SignInActionActionHandler() {
	}

	@Override
	public SignInActionResult execute(SignInAction action,
			ExecutionContext context) throws ActionException {
		UserService userService = UserServiceFactory.getUserService();
		User usergae = userService.getCurrentUser();
		try {
			user = ofy().load().type(CurrentUser.class)
					.filter("email", usergae.getEmail()).first().safe();
			if (!user.isAdmin() && userService.isUserAdmin()) {
				user.setIsAdmin(userService.isUserAdmin());
				user.setNickname(usergae.getEmail());
				user.set_updatedAt(new Date());
				ofy().save().entity(user);
			}
		} catch (NotFoundException e) {
			user = new CurrentUser();
			user.set_createdAt(new Date());
			user.setIsAdmin(userService.isUserAdmin());
			user.setEmail(usergae.getEmail());
			user.setNickname(usergae.getEmail());
			user.setLogoutUrl((userService.createLogoutURL(action.getRequest())));
			user.setNickname(usergae.getNickname());
			user.setLoginUrl(userService.createLoginURL(action.getRequest()));
			user.setId(user.getEmail());
			user.setUserId("USER: " + UUID.randomUUID().toString());
			user.set_createdBy("9leinad0@gmail.com");
			if (user.isAdmin()) {
				user.setFacultad("FIIS");
				user.setUniversidad("UNI");
				user.setIsGuest(false);
			} else {
				user.setFacultad("---");
				user.setUniversidad("---");
				user.setIsGuest(true);
			}
			user.setIsPublisher(false);
			user.set_kindName("CurrentUser");
			user.set_owner("USER: " + UUID.randomUUID().toString());
			user.set_updatedAt(new Date());
			user.set_updatedBy("9leinad0@gmail.com");
			ofy().save().entity(user);
		}
		return new SignInActionResult(user.getDto());
	}

	@Override
	public void undo(SignInAction action, SignInActionResult result,
			ExecutionContext context) throws ActionException {
	}

	@Override
	public Class<SignInAction> getActionType() {
		return SignInAction.class;
	}
}
