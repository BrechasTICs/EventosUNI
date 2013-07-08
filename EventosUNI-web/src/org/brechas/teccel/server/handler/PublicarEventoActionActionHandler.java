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
import com.googlecode.objectify.NotFoundException;
import com.googlecode.objectify.Ref;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class PublicarEventoActionActionHandler implements
		ActionHandler<PublicarEventoAction, PublicarEventoActionResult> {
	public boolean respuesta=false;
	@Inject
	public PublicarEventoActionActionHandler() {
	}	
	@Override
	public PublicarEventoActionResult execute(PublicarEventoAction action,
			ExecutionContext context) throws ActionException {
		int i,j;
		CurrentUser user;
		try{
		user=ofy().load().type(CurrentUser.class).filter("email", action.getRequest()).first().safe();
		/**
		 * Declarar Entities y Lists
		 */
		Evento evento = new Evento();
		evento.up(user);
		TipoEvento tipoEvento = new TipoEvento();
		tipoEvento.up(user);
		List<Organizador> listOrganizador=new ArrayList<Organizador>();
		List<Contacto> listCon=new ArrayList<Contacto>();
		List<Actividad> listActividad=new ArrayList<Actividad>();
		List<Lugar> listLugar=new ArrayList<Lugar>();
		List<Tiempo> listTiempo=new ArrayList<Tiempo>();
		/**
		 *
		 */
		Organizador org = new Organizador();
		org.up(user);
		Contacto con = new Contacto();
		con.up(user);
		Actividad act= new Actividad();
		act.up(user);
		Lugar lug = new Lugar();
		lug.up(user);
		Tiempo	tie=new Tiempo();
		tie.up(user);
		/**
		 * Recibir Dtos y colocarlos en Entities
		 */
		tipoEvento.setDto(action.getTipoEvento());
		evento.setDto(action.getEvento());
		for(i=0;i<action.getListOrganizador().size();i++){
			org = new Organizador();
			org.up(user);
			org.setDto(action.getListOrganizador().get(i));
			listOrganizador.add(org);
			org.getEvento().add(Ref.create(evento));
			evento.getOrganizador().add(Ref.create(org));
			for(j=0;j<action.getListContacto().get(i).size();j++){
				con = new Contacto();
				con.up(user);
				con.setDto(action.getListContacto().get(i).get(j));
				con.setOrganizador(Ref.create(org));
				listCon.add(con);
				org.getContacto().add(Ref.create(con));				
			}
		}
		for(i=0;i<action.getListActividad().size();i++){
			act= new Actividad();
			act.up(user);
			act.setDto(action.getListActividad().get(i));			
			lug = new Lugar();
			lug.up(user);
			lug.setDto(action.getListLugar().get(i));			
			tie=new Tiempo();
			tie.up(user);
			tie.setDto(action.getListTiempo().get(i));			
			act.setLugar(Ref.create(lug));
			act.setTiempo(Ref.create(tie));
			lug.setActividad(Ref.create(act));
			tie.setActividad(Ref.create(act));
			evento.getActividad().add((Ref.create(act)));
			listActividad.add(act);
			listLugar.add(lug);
			listTiempo.add(tie);
		}
		/**
		 * Salvaguardarlos
		 */
		ofy().save().entity(tipoEvento);
		ofy().save().entities(listLugar);
		ofy().save().entities(listTiempo);
		ofy().save().entities(listActividad);
		ofy().save().entities(listCon);
		ofy().save().entities(listOrganizador);
		ofy().save().entity(evento);
		respuesta=true;
		return new PublicarEventoActionResult(respuesta);
		}catch(NotFoundException e){
			throw new ActionException(e);
		}
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
