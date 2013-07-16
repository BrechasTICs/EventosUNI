package org.brechas.teccel.server.handler;

import static org.brechas.teccel.server.objectify.OfyService.ofy;

import java.util.ArrayList;
import java.util.List;

import org.brechas.teccel.client.action.RegisterOrganizador;
import org.brechas.teccel.client.action.RegisterOrganizadorResult;
import org.brechas.teccel.server.entity.Contacto;
import org.brechas.teccel.server.entity.CurrentUser;
import org.brechas.teccel.server.entity.Organizador;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.inject.Inject;
import com.googlecode.objectify.Ref;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class RegisterOrganizadorActionHandler implements
		ActionHandler<RegisterOrganizador, RegisterOrganizadorResult> {

	@Inject
	public RegisterOrganizadorActionHandler() {
	}

	@Override
	public RegisterOrganizadorResult execute(RegisterOrganizador action,
			ExecutionContext context) throws ActionException {
		int i;
		CurrentUser user = new CurrentUser();
		try {
			user = ofy().load().type(CurrentUser.class)
					.filter("email", action.getRequest()).first().safe();
			/**
			 * Declarar Entities y Lists
			 */
			Organizador organizador = new Organizador();
			List<Contacto> listCon = new ArrayList<Contacto>();
			/**
		 *
		 */
			organizador.up(user);
			Contacto con;
			/**
			 * Recibir Dtos y colocarlos en Entities
			 */
			organizador.setDto(action.getOrganizador());
			for (i = 0; i < action.getListContacto().size(); i++) {
				con = new Contacto();
				con.up(user);
				con.setDto(action.getListContacto().get(i));
				con.setOrganizador(Ref.create(organizador));
				listCon.add(con);
				organizador.getContacto().add(Ref.create(listCon.get(i)));
			}
			/**
			 * Salvaguardarlos
			 */
			ofy().save().entities(listCon);
			ofy().save().entity(organizador);
			return new RegisterOrganizadorResult();
		} catch (Exception e) {
			throw new ActionException(e + "//" + user.toString() + "/n//"
					+ action.getRequest());
		}
	}

	@Override
	public void undo(RegisterOrganizador action,
			RegisterOrganizadorResult result, ExecutionContext context)
			throws ActionException {
	}

	@Override
	public Class<RegisterOrganizador> getActionType() {
		return RegisterOrganizador.class;
	}
}
