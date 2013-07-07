package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MenuHomeView extends ViewImpl implements MenuHomePresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, MenuHomeView> {
	}
	
	@Inject
	public MenuHomeView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@UiField Label publicarEventos;
	@UiField Label verEventos;
	@UiField Label registrarOrganizador;
	
	public Label getPublicarEventos() {
		return publicarEventos;
	}

	public Label getVerEventos() {
		return verEventos;
	}
	
	public Label getRegistrarOrganizador() {
		return registrarOrganizador;
	}
}
