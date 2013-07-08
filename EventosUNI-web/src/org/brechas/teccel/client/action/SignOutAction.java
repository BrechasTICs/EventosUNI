package org.brechas.teccel.client.action;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.ActionImpl;
import org.brechas.teccel.client.action.SignOutActionResult;
import java.lang.String;

public class SignOutAction extends ActionImpl<SignOutActionResult> {

	private String email;

	@SuppressWarnings("unused")
	@Inject
	public SignOutAction() {
		// For serialization only
	}

	public SignOutAction(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
}
