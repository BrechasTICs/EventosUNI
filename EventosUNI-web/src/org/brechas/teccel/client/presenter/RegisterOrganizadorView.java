package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class RegisterOrganizadorView extends ViewImpl implements
		RegisterOrganizadorPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, RegisterOrganizadorView> {
	}

	@Inject
	public RegisterOrganizadorView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@UiField
	TextBox nombre;
	@UiField
	TextArea descripcion;
	@UiField
	HTMLPanel panelContacto;
	@UiField
	FlexTable telefono;
	@UiField
	FlexTable direccion;
	@UiField
	FlexTable email;
	@UiField
	FlexTable paginaweb;
	Button masTelefono = new Button("+");
	Button masDireccion = new Button("+");
	Button masEmail = new Button("+");
	Button masPaginaweb = new Button("+");
	Button menosTelefono = new Button("x");
	Button menosDireccion = new Button("x");
	Button menosEmail = new Button("x");
	Button menosPaginaweb = new Button("x");

	public Button getMasTelefono() {
		return masTelefono;
	}

	public Button getMasDireccion() {
		return masDireccion;
	}

	public Button getMasEmail() {
		return masEmail;
	}

	public Button getMasPaginaweb() {
		return masPaginaweb;
	}

	public Button getMenosTelefono() {
		return menosTelefono;
	}

	public Button getMenosDireccion() {
		return menosDireccion;
	}

	public Button getMenosEmail() {
		return menosEmail;
	}

	public Button getMenosPaginaweb() {
		return menosPaginaweb;
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub
		if (slot == WidgetOrganizadorPresenter.SLOT_Contacto) {
			setContactoContent(content);
		} else {
			super.setInSlot(slot, content);
		}

	}

	@Override
	public void addToSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub
		if (slot == WidgetOrganizadorPresenter.SLOT_Contacto) {
			addContactoContent(content);
		} else {
			super.addToSlot(slot, content);
		}

	}

	public void setContactoContent(Widget content) {
		panelContacto.clear();
		if (content != null) {
			panelContacto.add(content);
		}
	}

	public void addContactoContent(Widget content) {
		panelContacto.add(content);
	}

	public TextBox getNombre() {
		return nombre;
	}

	public TextArea getDescripcion() {
		return descripcion;
	}

	public HTMLPanel getPanelContacto() {
		return panelContacto;
	}

	public FlexTable getTelefono() {
		return telefono;
	}

	public FlexTable getDireccion() {
		return direccion;
	}

	public FlexTable getEmail() {
		return email;
	}

	public FlexTable getPaginaweb() {
		return paginaweb;
	}

}
