package org.brechas.teccel.client.presenter;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;

import org.brechas.teccel.client.action.SignInActionResult;
import org.brechas.teccel.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import org.brechas.teccel.client.presenter.LayoutPresenter;
import org.brechas.teccel.client.action.PublicarEventoAction;
import org.brechas.teccel.client.action.PublicarEventoActionResult;

public class ViewEventPresenter extends
		Presenter<ViewEventPresenter.MyView, ViewEventPresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.viewevent)
	public interface MyProxy extends ProxyPlace<ViewEventPresenter> {
	}

	@Inject
	public ViewEventPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Inject DispatchAsync dispatchAsync;
	@Inject PublicarEventoAction publicar;
	@Inject LoginPresenter login;
	
	@Override
	protected void revealInParent() {
		RevealContentEvent
				.fire(this, LayoutPresenter.SLOT_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
		publicar=new PublicarEventoAction();
		publicar.setRequest(login.getView().getNickname().getText());
		dispatchAsync.execute(publicar, publicarActionCallback);
	}

	private AsyncCallback<PublicarEventoActionResult> publicarActionCallback = new AsyncCallback<PublicarEventoActionResult>() {
		public void onFailure(Throwable caught) {
			Window.alert("Error: " + caught.getMessage());
		};

		public void onSuccess(PublicarEventoActionResult result) {
		}
	};
}
