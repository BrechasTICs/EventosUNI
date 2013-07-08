package org.brechas.teccel.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import org.brechas.teccel.client.action.SignInAction;
import org.brechas.teccel.server.handler.SignInActionActionHandler;
import org.brechas.teccel.client.action.PublicarEventoAction;
import org.brechas.teccel.server.handler.PublicarEventoActionActionHandler;
import org.brechas.teccel.client.action.RegisterOrganizador;
import org.brechas.teccel.server.handler.RegisterOrganizadorActionHandler;
import org.brechas.teccel.client.action.SignOutAction;
import org.brechas.teccel.server.handler.SignOutActionActionHandler;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {
		

		bindHandler(SignInAction.class, SignInActionActionHandler.class);

		bindHandler(PublicarEventoAction.class,
				PublicarEventoActionActionHandler.class);

		bindHandler(RegisterOrganizador.class,
				RegisterOrganizadorActionHandler.class);

		bindHandler(SignOutAction.class, SignOutActionActionHandler.class);
	}
}
