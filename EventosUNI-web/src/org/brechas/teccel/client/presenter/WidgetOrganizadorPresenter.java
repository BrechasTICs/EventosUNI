package org.brechas.teccel.client.presenter;

import com.gwtplatform.common.client.IndirectProvider;
import com.gwtplatform.common.client.StandardProvider;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class WidgetOrganizadorPresenter extends
		PresenterWidget<WidgetOrganizadorPresenter.MyView> {

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Contacto = new Type<RevealContentHandler<?>>();
	private IndirectProvider<WidgetContactoPresenter> providerContacto;

	public interface MyView extends View {
		public TextBox getNombre();

		public TextArea getDescripcion();

		public Button getAgregarContacto();

		public Button getEliminarOrganizador();

		public HTMLPanel getPanelContacto();
	}

	@Inject
	public WidgetOrganizadorPresenter(final EventBus eventBus,
			final MyView view,
			Provider<WidgetContactoPresenter> providerContacto) {
		super(eventBus, view);
		this.providerContacto = new StandardProvider<WidgetContactoPresenter>(
				providerContacto);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getEliminarOrganizador().addClickHandler(
				eliminaOrganizadorHandler);
		getView().getAgregarContacto().addClickHandler(agregarContactoHandler);
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
	}

	ClickHandler eliminaOrganizadorHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			removeFromSlot(PublishEventPresenter.SLOT_Organizador,
					WidgetOrganizadorPresenter.this);
		}
	};
	ClickHandler agregarContactoHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			providerContacto.get(conMasCallback);
		}
	};
	AsyncCallback<WidgetContactoPresenter> conMasCallback = new AsyncCallback<WidgetContactoPresenter>() {

		@Override
		public void onSuccess(WidgetContactoPresenter result) {
			// TODO Auto-generated method stub
			addToSlot(SLOT_Contacto, result);
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert("Con Fail!");

		}
	};
}
