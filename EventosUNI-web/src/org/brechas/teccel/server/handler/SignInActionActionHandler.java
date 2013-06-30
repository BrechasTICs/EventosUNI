package org.brechas.teccel.server.handler;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import org.brechas.teccel.client.action.SignInAction;
import org.brechas.teccel.client.action.SignInActionResult;
import org.brechas.teccel.server.beans.LoginInfo;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class SignInActionActionHandler implements
		ActionHandler<SignInAction, SignInActionResult> {

	
	@Inject
	public SignInActionActionHandler() {
	}

	@Override
	public SignInActionResult execute(SignInAction action, ExecutionContext context)
			throws ActionException {
            UserService userService = UserServiceFactory.getUserService();
            User user = userService.getCurrentUser();
            LoginInfo loginInfo = new LoginInfo();
            
            if (user != null) {
              loginInfo.setLoggedIn(true);
              loginInfo.setNickname(user.getEmail());
              loginInfo.setEmailAddress(userService.createLogoutURL(action.getRequest()));     
            } else {
              loginInfo.setLoggedIn(false);
              loginInfo.setNickname(userService.createLoginURL(action.getRequest()));
              loginInfo.setEmailAddress(null);
            }
            
        return new SignInActionResult(loginInfo.getEmailAddress(), loginInfo.getNickname());
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
