package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.widget.client.TextButton;

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
	@UiField SimplePanel flexActividad;
	@UiField FormPanel formActividad;
	@UiField SimplePanel flexOrganizador;
	@UiField FormPanel formEvento;
	@UiField FormPanel formOrganizador;
	@UiField FileUpload imagenEvento;
	@UiField TextBox nombreEvento;
	@UiField TextArea descripcionEvento;
	@UiField ListBox tipoEvento;
	@UiField ListBox estadoEvento;
	@UiField TextArea requisitoEvento;
	@UiField TextArea observacionEvento;
	@UiField TextButton agregarOrganizador;
	@UiField TextButton agregarActividad;
	@UiField Label tipoEventoM;
	@UiField ListBox tipoEventoN;
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub
		if (slot == LayoutPresenter.SLOT_SetMainContent)
		{			
			setOrganizadorContent(content);
		}
 		else if (slot == LayoutPresenter.SLOT_SetLoginContent)
		{
			setActividadContent(content);
		}
 		else 
		{
 			super.setInSlot(slot, content);
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
	public SimplePanel getFlexActividad() {
		return flexActividad;
	}

	public FormPanel getFormActividad() {
		return formActividad;
	}

	public SimplePanel getFlexOrganizador() {
		return flexOrganizador;
	}

	public FormPanel getFormEvento() {
		return formEvento;
	}

	public FormPanel getFormOrganizador() {
		return formOrganizador;
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

	public TextButton getAgregarOrganizador() {
		return agregarOrganizador;
	}

	public TextButton getAgregarActividad() {
		return agregarActividad;
	}

	public Label getTipoEventoM() {
		return tipoEventoM;
	}

	public ListBox getTipoEventoN() {
		return tipoEventoN;
	}
	
}
