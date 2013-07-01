package org.brechas.teccel.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import org.brechas.teccel.client.action.SignInAction;
import org.brechas.teccel.server.handler.SignInActionActionHandler;
import org.brechas.teccel.client.action.PublicarEventoAction;
import org.brechas.teccel.server.handler.PublicarEventoActionActionHandler;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {
		

		bindHandler(SignInAction.class, SignInActionActionHandler.class);

		bindHandler(PublicarEventoAction.class,
				PublicarEventoActionActionHandler.class);
	}
}
