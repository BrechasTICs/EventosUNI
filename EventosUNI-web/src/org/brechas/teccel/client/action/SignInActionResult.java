package org.brechas.teccel.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.String;

public class SignInActionResult implements Result {

	private String email;
	private String nickname;

	@SuppressWarnings("unused")
	private SignInActionResult() {
		// For serialization only
	}

	public SignInActionResult(String email, String nickname) {
		this.email = email;
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}
}
