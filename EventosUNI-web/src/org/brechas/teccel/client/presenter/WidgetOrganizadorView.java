package org.brechas.teccel.client.presenter;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class WidgetOrganizadorView extends ViewImpl implements
		WidgetOrganizadorPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, WidgetOrganizadorView> {
	}
	@Inject
	PublishEventPresenter publishEventPresenter;

	@Inject
	public WidgetOrganizadorView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@UiField TextBox nombre;
	@UiField TextArea descripcion;
	@UiField Button agregarContacto;
	@UiField Button eliminarOrganizador;
	@UiField HTMLPanel panelContacto;
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub
		if (slot == WidgetOrganizadorPresenter.SLOT_Contacto)
		{			
			setContactoContent(content);
		}else 
		{
 			super.setInSlot(slot, content);
		}
		
	}
	@Override
	public void addToSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub
		if (slot == WidgetOrganizadorPresenter.SLOT_Contacto)
		{			
			addContactoContent(content);
		}else 
		{
 			super.addToSlot(slot, content);
		}
		
	}
	@Override
	public void removeFromSlot(Object slot, Widget content) {
	    if (slot == PublishEventPresenter.SLOT_Organizador) {
	    	removeContactoContent(content);
	    } else {
	        super.removeFromSlot(slot, content);
	    }
	}
	public void removeContactoContent(Widget content) 
	{
		publishEventPresenter.getView().getFlexOrganizador().remove(content);
	}
	public void setContactoContent(Widget content) 
	{
	    panelContacto.clear();
	    if (content != null) 
	    {
	    panelContacto.add(content);
	    }
	}
	public void addContactoContent(Widget content) 
	{	    
	    panelContacto.add(content);  
	}
	
	public TextBox getNombre() {
		return nombre;
	}

	public TextArea getDescripcion() {
		return descripcion;
	}

	public Button getAgregarContacto() {
		return agregarContacto;
	}

	public Button getEliminarOrganizador() {
		return eliminarOrganizador;
	}

	public HTMLPanel getPanelContacto() {
		return panelContacto;
	}
	
	
}
