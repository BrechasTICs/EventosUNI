package org.brechas.teccel.client.presenter;

import org.brechas.teccel.client.place.NameTokens;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.widget.client.TextButton;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.common.client.IndirectProvider;
import com.gwtplatform.common.client.StandardProvider;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class PublishEventPresenter extends
		Presenter<PublishEventPresenter.MyView, PublishEventPresenter.MyProxy> {

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Actividad = new Type<RevealContentHandler<?>>();
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_Organizador = new Type<RevealContentHandler<?>>();
	
	public interface MyView extends View {
		public SimplePanel getFlexActividad();

		public FormPanel getFormActividad();

		public SimplePanel getFlexOrganizador();

		public FormPanel getFormEvento();

		public FormPanel getFormOrganizador();

		public FileUpload getImagenEvento();

		public TextBox getNombreEvento();

		public TextArea getDescripcionEvento();

		public ListBox getTipoEvento();

		public ListBox getEstadoEvento();

		public TextArea getRequisitoEvento();

		public TextArea getObservacionEvento();

		public TextButton getAgregarOrganizador();

		public TextButton getAgregarActividad();

		public Label getTipoEventoM();

		public ListBox getTipoEventoN();
	}

	private IndirectProvider<WidgetActividadPresenter> providerActividad;

	@ProxyCodeSplit
	@NameToken(NameTokens.publishevent)
	public interface MyProxy extends ProxyPlace<PublishEventPresenter> {
	}

	@Inject
	public PublishEventPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			Provider<WidgetActividadPresenter> providerActividad) {
		super(eventBus, view, proxy);
		this.providerActividad = new StandardProvider<WidgetActividadPresenter>(
				providerActividad);
	}

	@Inject
	WidgetActividadPresenter widgetActividad;

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutPresenter.SLOT_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		getView().getAgregarActividad()
				.addClickHandler(agregarActividadHandler);
		// widgetActividad.getView()
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
	}

	ClickHandler agregarActividadHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			providerActividad.get(actMasCallback);
		}
	};
	ClickHandler eliminaActividadHanlder = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			providerActividad.get(actMenosCallback);
		}
	};
	AsyncCallback<WidgetActividadPresenter> actMasCallback = new AsyncCallback<WidgetActividadPresenter>() {

		@Override
		public void onSuccess(WidgetActividadPresenter result) {
			// TODO Auto-generated method stub
			addToSlot(SLOT_Actividad, result);
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}
	};
	AsyncCallback<WidgetActividadPresenter> actMenosCallback = new AsyncCallback<WidgetActividadPresenter>() {

		@Override
		public void onSuccess(WidgetActividadPresenter result) {
			// TODO Auto-generated method stub
			removeFromSlot(SLOT_Actividad, result);
		}

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub

		}
	};
}
