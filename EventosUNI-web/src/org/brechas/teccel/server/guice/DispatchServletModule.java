package org.brechas.teccel.server.guice;

import org.brechas.teccel.server.config.ConfigurationServlet;
import org.brechas.teccel.server.spi.ProspectiveSearchServlet;

import com.google.api.server.spi.SystemServiceServlet;
import com.google.appengine.labs.repackaged.com.google.common.collect.ImmutableMap;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.shared.ActionImpl;

public class DispatchServletModule extends ServletModule {

	@Override
	public void configureServlets() {
		serve("/" + ActionImpl.DEFAULT_SERVICE_NAME).with(
				DispatchServiceImpl.class);
		filter("/*").through(ObjectifyFilter.class);
		serve("/_ah/spi/*").with(SystemServiceServlet.class,ImmutableMap.of("services","org.brechas.teccel.server.spi.EndpointV1"));
		serve("/_ah/prospective_search").with(ProspectiveSearchServlet.class);
		serve("/admin/cconf").with(ConfigurationServlet.class);
		
	}
}
