package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.widget.client.TextButton;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.IntegerBox;

public class WidgetActividadView extends ViewImpl implements
		WidgetActividadPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, WidgetActividadView> {
	}

	@Inject
	public WidgetActividadView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	@UiField TextButton eliminaActividad;
	@UiField CheckBox checkIsUni;
	@UiField TextBox nombreActividad;
	@UiField TextArea descripcionActividad;
	@UiField ListBox EstadoActividad;
	@UiField TextArea lugarActividad;
	@UiField DateBox dateInicio;
	@UiField DateBox dateFin;
	@UiField IntegerBox capacidadActividad;
	@UiField ListBox timeZoneInicio;
	@UiField ListBox timeZoneFin;
	@UiField TextBox pais;
	@UiField TextBox region;
	@UiField TextBox provincia;
	@UiField TextBox Distrito;
	@UiField TextBox direccion;
	
	public TextButton getEliminaActividad() {
		return eliminaActividad;
	}

	public CheckBox getCheckIsUni() {
		return checkIsUni;
	}

	public TextBox getNombreActividad() {
		return nombreActividad;
	}

	public TextArea getDescripcionActividad() {
		return descripcionActividad;
	}

	public ListBox getEstadoActividad() {
		return EstadoActividad;
	}

	public TextArea getLugarActividad() {
		return lugarActividad;
	}

	public DateBox getDateInicio() {
		return dateInicio;
	}

	public DateBox getDateFin() {
		return dateFin;
	}

	public IntegerBox getCapacidadActividad() {
		return capacidadActividad;
	}

	public ListBox getTimeZoneInicio() {
		return timeZoneInicio;
	}

	public ListBox getTimeZoneFin() {
		return timeZoneFin;
	}

	public TextBox getPais() {
		return pais;
	}

	public TextBox getRegion() {
		return region;
	}

	public TextBox getProvincia() {
		return provincia;
	}

	public TextBox getDistrito() {
		return Distrito;
	}

	public TextBox getDireccion() {
		return direccion;
	}
}
