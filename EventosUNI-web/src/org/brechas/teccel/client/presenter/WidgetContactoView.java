package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class WidgetContactoView extends ViewImpl implements
		WidgetContactoPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, WidgetContactoView> {
	}

	@Inject
	WidgetOrganizadorPresenter widgetOrganizadorPresenter;
	@Inject
	public WidgetContactoView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@UiField
	ListBox tipo;
	@UiField
	TextArea valor;
	@UiField
	Button eliminarContacto;


	@Override
	public void removeFromSlot(Object slot, Widget content) {
	    if (slot == WidgetOrganizadorPresenter.SLOT_Contacto) {
	    	removeContactoContent(content);
	    } else {
	    	Window.alert("_____");
	        super.removeFromSlot(slot, content);
	    }
	}
	
	public void removeContactoContent(Widget content) 
	{
		Window.alert(""+widgetOrganizadorPresenter.getView().getPanelContacto().toString());
	}
	public ListBox getTipo() {
		return tipo;
	}

	public TextArea getValor() {
		return valor;
	}

	public Button getEliminarContacto() {
		return eliminarContacto;
	}

}
