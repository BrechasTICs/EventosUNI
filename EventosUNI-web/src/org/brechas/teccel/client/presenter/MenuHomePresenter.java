package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;
import org.brechas.teccel.client.place.NameTokens;

public class MenuHomePresenter extends
		PresenterWidget<MenuHomePresenter.MyView> {

	public interface MyView extends View {
		public Label getPublicarEventos();
		public Label getVerEventos();
		public Label getRegistrarOrganizador();
	}
	@Inject
	PlaceManager placeManager;
	@Inject
	public MenuHomePresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getPublicarEventos().addClickHandler(publicarEventosHandler);
		getView().getVerEventos().addClickHandler(verEventosHandler);
		getView().getRegistrarOrganizador().addClickHandler(regOrganizadorHandler);
	}
	ClickHandler publicarEventosHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = new PlaceRequest(NameTokens.publishevent);				
			placeManager.revealPlace(request);
		}
	};
	ClickHandler verEventosHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = new PlaceRequest(NameTokens.viewevent);				
			placeManager.revealPlace(request);
		}
	};
	ClickHandler regOrganizadorHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			PlaceRequest request = new PlaceRequest(NameTokens.registerorganizador);				
			placeManager.revealPlace(request,false);
		}
	};
}
