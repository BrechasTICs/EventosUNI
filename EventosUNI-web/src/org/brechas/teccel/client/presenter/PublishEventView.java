package org.brechas.teccel.client.presenter;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class PublishEventView extends ViewImpl implements
		PublishEventPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, PublishEventView> {
	}

	@Inject
	public PublishEventView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	@UiField HTMLPanel flexActividad;
	@UiField HTMLPanel flexOrganizador;
	@UiField FormPanel formEvento;
	@UiField FileUpload imagenEvento;
	@UiField TextBox nombreEvento;
	@UiField TextArea descripcionEvento;
	@UiField ListBox tipoEvento;
	@UiField ListBox estadoEvento;
	@UiField TextArea requisitoEvento;
	@UiField TextArea observacionEvento;
	@UiField Button agregarOrganizador;
	@UiField Button agregarActividad;
	@UiField Label tipoEventoM;
	@UiField ListBox tipoEventoN;
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub
		if (slot == PublishEventPresenter.SLOT_Organizador)
		{			
			setOrganizadorContent(content);
		}
 		else if (slot == PublishEventPresenter.SLOT_Actividad)
		{
			setActividadContent(content);
		}
 		else 
		{
 			super.setInSlot(slot, content);
		}
	}
	@Override
	public void addToSlot(Object slot, Widget content) {
	    if (slot == PublishEventPresenter.SLOT_Actividad) {
	    	addActividadContent(content);
	    } else  if (slot == PublishEventPresenter.SLOT_Organizador) {
	    	addOrganizadorContent(content);;
	    }else
	    {
	        super.addToSlot(slot, content);
	    }
	}
	
	public void setOrganizadorContent(Widget content) 
	{
	    flexOrganizador.clear();
	    if (content != null) 
	    {
	      flexOrganizador.add(content);
	    }
	}
	public void setActividadContent(Widget content) 
	{
	    flexActividad.clear();
	    if (content != null) 
	    {
	      flexActividad.add(content);
	    }
	}
	public void addOrganizadorContent(Widget content) 
	{
		flexOrganizador.add(content);
	}
	public void addActividadContent(Widget content) 
	{
		flexActividad.add(content);
	}
	public HTMLPanel getFlexActividad() {
		return flexActividad;
	}

	public HTMLPanel getFlexOrganizador() {
		return flexOrganizador;
	}

	public FormPanel getFormEvento() {
		return formEvento;
	}

	public FileUpload getImagenEvento() {
		return imagenEvento;
	}

	public TextBox getNombreEvento() {
		return nombreEvento;
	}

	public TextArea getDescripcionEvento() {
		return descripcionEvento;
	}

	public ListBox getTipoEvento() {
		return tipoEvento;
	}

	public ListBox getEstadoEvento() {
		return estadoEvento;
	}

	public TextArea getRequisitoEvento() {
		return requisitoEvento;
	}

	public TextArea getObservacionEvento() {
		return observacionEvento;
	}

	public Button getAgregarOrganizador() {
		return agregarOrganizador;
	}

	public Button getAgregarActividad() {
		return agregarActividad;
	}

	public Label getTipoEventoM() {
		return tipoEventoM;
	}

	public ListBox getTipoEventoN() {
		return tipoEventoN;
	}
	
}
