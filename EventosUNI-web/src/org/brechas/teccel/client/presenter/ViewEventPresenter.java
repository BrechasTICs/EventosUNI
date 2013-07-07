package org.brechas.teccel.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;

import org.brechas.teccel.client.action.SignInActionResult;
import org.brechas.teccel.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import org.brechas.teccel.client.presenter.LayoutPresenter;
import org.brechas.teccel.client.action.PublicarEventoAction;
import org.brechas.teccel.client.action.PublicarEventoActionResult;
import org.brechas.teccel.client.event.EmailEvent;
import org.brechas.teccel.client.event.EmailEvent.EmailHandler;
import org.brechas.teccel.server.entity.Lugar;
import org.brechas.teccel.shared.entity.ActividadDto;
import org.brechas.teccel.shared.entity.ContactoDto;
import org.brechas.teccel.shared.entity.EventoDto;
import org.brechas.teccel.shared.entity.LugarDto;
import org.brechas.teccel.shared.entity.OrganizadorDto;
import org.brechas.teccel.shared.entity.TiempoDto;
import org.brechas.teccel.shared.entity.TipoEventoDto;

public class ViewEventPresenter extends
		Presenter<ViewEventPresenter.MyView, ViewEventPresenter.MyProxy> implements EmailHandler{

	public String email;
	private EventBus eventBus;
	public interface MyView extends View {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.viewevent)
	public interface MyProxy extends ProxyPlace<ViewEventPresenter> {
	}

	@Inject
	public ViewEventPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
		this.eventBus=eventBus;
	}

	@Inject DispatchAsync dispatchAsync;
	@Inject PublicarEventoAction publicar;
	
	@Override
	protected void revealInParent() {
		RevealContentEvent
				.fire(this, LayoutPresenter.SLOT_SetMainContent, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		addRegisteredHandler(EmailEvent.getType(), this );
	}

	public void onEmail(EmailEvent event) {
	    email=event.getEmail();
	  }
	
	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
		EmailEvent emailEvent =new EmailEvent();
		List<OrganizadorDto> listOrganizador=new ArrayList<OrganizadorDto>();
		listOrganizador.add(new OrganizadorDto());
		List<List<ContactoDto>> listContacto=new ArrayList<List<ContactoDto>>();
		List<ContactoDto> listCont=new ArrayList<ContactoDto>();
		listCont.add(new ContactoDto());
		listCont.add(new ContactoDto());
		listCont.add(new ContactoDto());
		listCont.add(new ContactoDto());
		listContacto.add(listCont);
		List<ActividadDto> listActividad=new ArrayList<ActividadDto>();
		listActividad.add(new ActividadDto());
		listActividad.add(new ActividadDto());
		List<LugarDto> listLugar=new ArrayList<LugarDto>();
		listLugar.add(new LugarDto());
		listLugar.add(new LugarDto());
		List<TiempoDto> listTiempo=new ArrayList<TiempoDto>();
		listTiempo.add(new TiempoDto());
		listTiempo.add(new TiempoDto());
		ViewEventPresenter.this.eventBus.fireEvent(emailEvent);
		publicar=new PublicarEventoAction();
		publicar.setRequest(email);
		publicar.setEvento(new EventoDto());
		publicar.setListActividad(listActividad);
		publicar.setListContacto(listContacto);
		publicar.setListLugar(listLugar);
		publicar.setListOrganizador(listOrganizador);
		publicar.setListTiempo(listTiempo);
		publicar.setTipoEvento(new TipoEventoDto());
		dispatchAsync.execute(publicar, publicarActionCallback);		
	}

	private AsyncCallback<PublicarEventoActionResult> publicarActionCallback = new AsyncCallback<PublicarEventoActionResult>() {
		public void onFailure(Throwable caught) {
		
			Window.alert("Error: " + caught.getMessage());
		};

		public void onSuccess(PublicarEventoActionResult result) {
			Window.alert("Gooood!");
		}
	};
}
