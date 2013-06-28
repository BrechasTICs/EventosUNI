package org.brechas.teccel.server.guice;

import com.google.inject.Singleton;
import com.googlecode.objectify.ObjectifyFilter;
import com.gwtplatform.dispatch.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {
		bind(ObjectifyFilter.class).in(Singleton.class);
	}
}
