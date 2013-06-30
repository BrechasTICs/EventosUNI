package org.brechas.teccel.client.presenter;

import java.lang.ProcessBuilder.Redirect;

import org.brechas.teccel.client.action.SignInAction;
import org.brechas.teccel.client.action.SignInActionResult;
import org.brechas.teccel.client.place.NameTokens;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.google.inject.Inject;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public class LoginPresenter extends PresenterWidget<LoginPresenter.MyView> {
	String logouturl=GWT.getHostPageBaseURL();
	ClickHandler logout = new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			redirect(logouturl);
		}
	};
	public interface MyView extends View {
		public Button getLoginButton();
		public Label getNickname(); 
	}

	@Inject
	public LoginPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getLoginButton().addClickHandler(logout);
	}
	
	@Inject
	PlaceManager placeManager;
	@Inject
	DispatchAsync dispatchAsync;
	@Inject
	SignInAction signInAction;
	
	@Override
	protected void onReset() {
		super.onReset();
		signInAction.setRequest(GWT.getHostPageBaseURL());
		dispatchAsync.execute(signInAction, signInActionCallback);
		}
	private AsyncCallback<SignInActionResult> signInActionCallback = new AsyncCallback<SignInActionResult>() {
		public void onFailure(Throwable caught) {
			Window.alert("No pudo Iniciar sesión: "+ caught.getMessage());
		};
		public void onSuccess(SignInActionResult result) {
			if(result.getEmail()==(null)){
				redirect(result.getNickname());
			}else{
				getView().getNickname().setText(result.getNickname());
				logouturl=result.getEmail();
			}
		}
	};
	native void redirect(String url)
	/*-{
	        $wnd.location.replace(url);
	}-*/; 
}
