package org.brechas.teccel.server.guice;

import org.brechas.teccel.server.config.ConfigurationServlet;
import org.brechas.teccel.server.spi.ProspectiveSearchServlet;

import com.google.api.server.spi.SystemServiceServlet;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.googlecode.objectify.ObjectifyFilter;

public class Module extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(ObjectifyFilter.class).in(Singleton.class);
		bind(SystemServiceServlet.class).in(Singleton.class);
		bind(ProspectiveSearchServlet.class).in(Singleton.class);
		bind(ConfigurationServlet.class).in(Singleton.class);
	}
}
