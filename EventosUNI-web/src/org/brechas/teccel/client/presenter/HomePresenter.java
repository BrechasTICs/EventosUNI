package org.brechas.teccel.client.presenter;

import org.brechas.teccel.client.action.SignInAction;
import org.brechas.teccel.client.action.SignInActionResult;
import org.brechas.teccel.client.place.NameTokens;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.google.inject.Inject;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class HomePresenter extends
		Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {
	
	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.home)
	public interface MyProxy extends ProxyPlace<HomePresenter> {
	}

	@Inject
	public HomePresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}
	@Inject
	DispatchAsync dispatchAsync;
	@Inject
	SignInAction signInAction;

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutPresenter.SLOT_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

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
				Window.alert("BIEN!");
			}
		}
		native void redirect(String url)
		/*-{
		        $wnd.location.replace(url);
		}-*/; 
	};
}
