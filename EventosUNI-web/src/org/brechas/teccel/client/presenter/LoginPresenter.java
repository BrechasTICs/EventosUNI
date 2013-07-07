package org.brechas.teccel.client.presenter;

import org.brechas.teccel.client.action.SignInAction;
import org.brechas.teccel.client.action.SignInActionResult;
import org.brechas.teccel.client.event.EmailEvent;
import org.brechas.teccel.client.event.EmailEvent.EmailHandler;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class LoginPresenter extends PresenterWidget<LoginPresenter.MyView>
		implements EmailHandler {
	String logouturl = GWT.getHostPageBaseURL();
	private static boolean online;
	ClickHandler logout = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			online = false;
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
		online = false;
		getView().getLoginButton().addClickHandler(logout);
		addRegisteredHandler(EmailEvent.getType(), this);
	}

	@Inject
	PlaceManager placeManager;
	@Inject
	DispatchAsync dispatchAsync;
	@Inject
	SignInAction signInAction;
	@Inject
	EmailEvent emailEvent;

	@Override
	protected void onReset() {
		super.onReset();
		if (!online) {
			signInAction.setRequest(GWT.getHostPageBaseURL());
			dispatchAsync.execute(signInAction, signInActionCallback);
		}
	}

	private AsyncCallback<SignInActionResult> signInActionCallback = new AsyncCallback<SignInActionResult>() {
		public void onFailure(Throwable caught) {
			Window.alert("No pudo Iniciar sesión: " + caught.getMessage());
		}

		public void onSuccess(SignInActionResult result) {
			if (result.getUser().getEmail() == (null)) {
				redirect(result.getUser().getLoginUrl());
			} else {
				getView().getNickname().setText(result.getUser().getEmail());
				logouturl = result.getUser().getLogoutUrl();
				online = true;
			}
		}
	};

	native void redirect(String url)
	/*-{
		$wnd.location.replace(url);
	}-*/;

	@Override
	public void onEmail(EmailEvent event) {
		// TODO Auto-generated method stub
		event.setEmail((getView().getNickname().getText()));
	}
}
