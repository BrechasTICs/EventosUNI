package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class MenuAdminView extends ViewImpl implements
		MenuAdminPresenter.MyView {

	@UiField Label perfil;
	@UiField Label padreRol;
	@UiField Label profesorRol;
	@UiField Label psicologoRol;
	@UiField Label alumnoUsuario;
	@UiField Label padreUsuario;
	@UiField Label profesorUsuario;
	@UiField Label psicologoUsuario;
	@UiField Label alumnoRol;
	@UiField Label alumnoBuscar;
	@UiField Label avanzadoBuscar;
	@UiField Label aulaBuscar;
	@UiField Label aulaAcad;
	@UiField Label cursoAcad;
	@UiField Label asigcursoAcad;
	@UiField Label habcursoAcad;
	@UiField Label profesorAcad;
	@UiField Label newaulaAcad;
	@UiField Label newgradoAcad;
	@UiField Label newseccionAcad;
	@UiField Label newperiodoAcad;
	@UiField Label newcursoAcad;
	@UiField Label academicoEstado;
	@UiField Label fisicoEstado;
	@UiField Label psicomotrizEstado;
	@UiField Label aulaEstado;
	@UiField Label grupoEstado;
	@UiField Label estadisticas;
	@UiField Label inicialEvaluacion;
	@UiField Label bpreguntasEvaluacion;
	@UiField Label elabpruebaEvaluacion;
	@UiField Label srespuestasEvaluacion;
	@UiField Label nuevaAlerta;
	@UiField Label bandejaAlerta;
	
	public interface Binder extends UiBinder<Widget, MenuAdminView> {
	}

	private final Widget widget;

	@Inject
	public MenuAdminView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@Inject
	PlaceManager placeManager;
	
}
