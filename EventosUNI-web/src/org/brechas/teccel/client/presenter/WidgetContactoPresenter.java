package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.widget.client.TextButton;

public class WidgetContactoPresenter extends
		PresenterWidget<WidgetContactoPresenter.MyView> {

	public interface MyView extends View {
		public ListBox getTipo();
		public TextArea getValor();
		public Button getEliminarContacto();
	}

	@Inject
	public WidgetContactoPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getEliminarContacto().addClickHandler(eliminaContactoHandler);
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
	}
	ClickHandler eliminaContactoHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			removeFromSlot(WidgetOrganizadorPresenter.SLOT_Contacto,
					WidgetContactoPresenter.this);
		}
	};

	
}
