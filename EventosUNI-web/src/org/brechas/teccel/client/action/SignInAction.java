package org.brechas.teccel.client.action;

import com.gwtplatform.dispatch.shared.ActionImpl;
import org.brechas.teccel.client.action.SignInActionResult;

public class SignInAction extends ActionImpl<SignInActionResult> {

	private String request;
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public SignInAction() {
	}
	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
}
