package org.brechas.teccel.client.presenter;

import org.brechas.teccel.client.place.NameTokens;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;

public class LoginPresenter extends PresenterWidget<LoginPresenter.MyView> {

	public interface MyView extends View {
		public Button getLoginButton();
	}

	@Inject
	public LoginPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
	
	@Inject
	PlaceManager placeManager;
	
	@Override
	protected void onReset() {
		super.onReset();

		getView().getLoginButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request = new PlaceRequest(NameTokens.main);				
				placeManager.revealPlace(request);
			}
		});
	}
}
