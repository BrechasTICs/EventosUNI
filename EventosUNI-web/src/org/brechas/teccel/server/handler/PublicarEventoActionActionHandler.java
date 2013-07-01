package org.brechas.teccel.server.handler;

import java.util.ArrayList;
import java.util.List;

import static org.brechas.teccel.server.objectify.OfyService.ofy;

import org.brechas.teccel.client.action.PublicarEventoAction;
import org.brechas.teccel.client.action.PublicarEventoActionResult;
import org.brechas.teccel.server.entity.Actividad;
import org.brechas.teccel.server.entity.Contacto;
import org.brechas.teccel.server.entity.CurrentUser;
import org.brechas.teccel.server.entity.Evento;
import org.brechas.teccel.server.entity.Lugar;
import org.brechas.teccel.server.entity.Organizador;
import org.brechas.teccel.server.entity.Tiempo;
import org.brechas.teccel.server.entity.TipoEvento;

import com.google.inject.Inject;
import com.googlecode.objectify.Ref;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class PublicarEventoActionActionHandler implements
		ActionHandler<PublicarEventoAction, PublicarEventoActionResult> {
	private boolean respuesta=false;
	@Inject
	public PublicarEventoActionActionHandler() {
	}
	CurrentUser user;
	@Override
	public PublicarEventoActionResult execute(PublicarEventoAction action,
			ExecutionContext context) throws ActionException {
		int i,j;
		user=ofy().load().type(CurrentUser.class).filter("email", action.getRequest()).first().now();
		/**
		 * Declarar Entities y Lists
		 */
		Evento evento = new Evento();
		evento.up(user);
		TipoEvento tipoEvento = new TipoEvento();
		tipoEvento.up(user);
		List<Organizador> listOrganizador=new ArrayList<Organizador>();
		List<List<Contacto>> listContacto=new ArrayList<List<Contacto>>();
		List<Actividad> listActividad=new ArrayList<Actividad>();
		List<Lugar> listLugar=new ArrayList<Lugar>();
		List<Tiempo> listTiempo=new ArrayList<Tiempo>();
		/**
		 * Recibir Dtos y colocarlos en Entities
		 */
		Organizador org = new Organizador();
		org.up(user);
		Contacto con = new Contacto();
		con.up(user);
		Actividad act= new Actividad();
		act.up(user);
		evento.setDto(action.getEvento());
		tipoEvento.setDto(action.getTipoEvento());
		Lugar lug = new Lugar();
		lug.up(user);
		Tiempo	tie=new Tiempo();
		tie.up(user);
		for(i=0;i<action.getListOrganizador().size();i++){
			org.setDto(action.getListOrganizador().get(i));
			listOrganizador.add(org);
			listOrganizador.get(i).getEvento().add(Ref.create(evento));
			evento.getOrganizador().add(Ref.create(listOrganizador.get(i)));
			for(j=0;j<action.getListContacto().get(i).size();j++){
				con.setDto(action.getListContacto().get(i).get(j));
				listContacto.get(i).add(con);
				listOrganizador.get(i).getContacto().add(Ref.create(listContacto.get(i).get(j)));				
			}
		}
		for(i=0;i<action.getListActividad().size();i++){
			act.setDto(action.getListActividad().get(i));
			listActividad.add(act);
			lug.setDto(action.getListLugar().get(i));
			listLugar.add(lug);
			tie.setDto(action.getListTiempo().get(i));
			listTiempo.add(tie);
			listActividad.get(i).setLugar(Ref.create(listLugar.get(i)));
			listActividad.get(i).setTiempo(Ref.create(listTiempo.get(i)));
			evento.getActividad().add((Ref.create(listActividad.get(i))));
		}
		/**
		 * Salvaguardarlos
		 */
		ofy().save().entity(tipoEvento);
		ofy().save().entities(listLugar);
		ofy().save().entities(listTiempo);
		ofy().save().entities(listActividad);
		for(i=0;i<listContacto.size();i++){
			ofy().save().entities(listContacto.get(i));
		}
		ofy().save().entities(listOrganizador);
		ofy().save().entity(evento);
		respuesta=true;
		return new PublicarEventoActionResult(respuesta);
	}

	@Override
	public void undo(PublicarEventoAction action,
			PublicarEventoActionResult result, ExecutionContext context)
			throws ActionException {
	}

	@Override
	public Class<PublicarEventoAction> getActionType() {
		return PublicarEventoAction.class;
	}
}
