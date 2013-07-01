package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.google.inject.Inject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.widget.client.TextButton;

public class WidgetActividadPresenter extends
		PresenterWidget<WidgetActividadPresenter.MyView> {

	public interface MyView extends View {
		public TextButton getEliminaActividad();
		public CheckBox getCheckIsUni();
		public TextBox getNombreActividad();
		public TextArea getDescripcionActividad();
		public ListBox getEstadoActividad();
		public TextArea getLugarActividad();
		public DateBox getDateInicio() ;
		public DateBox getDateFin() ;
		public IntegerBox getCapacidadActividad();
		public ListBox getTimeZoneInicio() ;
		public ListBox getTimeZoneFin();
		public TextBox getPais() ;
		public TextBox getRegion() ;
		public TextBox getProvincia();
		public TextBox getDistrito() ;
		public TextBox getDireccion() ;
	}
	public WidgetActividadPresenter getPresent(){
		return this;
	}

	@Inject
	public WidgetActividadPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getEliminaActividad().addClickHandler(eliminaActividadHanlder);
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
	}
	ClickHandler eliminaActividadHanlder = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			removeFromSlot(PublishEventPresenter.SLOT_Actividad,getPresent());
		}
	};
}
