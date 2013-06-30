package org.brechas.teccel.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

import org.brechas.teccel.server.entity.CurrentUser;
import org.brechas.teccel.shared.entity.CurrentUserDto;

public class SignInActionResult implements Result {

	private CurrentUserDto user;

	@SuppressWarnings("unused")
	private SignInActionResult() {
		// For serialization only
	}

	public SignInActionResult(CurrentUserDto user) {
		this.setUser(user);
	}

	public CurrentUserDto getUser() {
		return user;
	}

	public void setUser(CurrentUserDto user) {
		this.user = user;
	}
}
