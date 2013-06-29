package org.brechas.teccel.server.guice;

import javax.servlet.ServletContextEvent;

import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.Injector;
import com.google.inject.Guice;
import org.brechas.teccel.server.guice.ServerModule;
import org.brechas.teccel.server.guice.DispatchServletModule;

public class GuiceServletConfig extends GuiceServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		long time =  System.currentTimeMillis();
		super.contextInitialized(servletContextEvent);
		long millis =System.currentTimeMillis() - time;
	}
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
				new ServerModule(), 
				new DispatchServletModule(), 
				new Module()
				);
	}
}
