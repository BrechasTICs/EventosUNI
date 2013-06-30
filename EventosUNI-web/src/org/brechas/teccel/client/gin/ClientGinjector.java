package org.brechas.teccel.client.gin;


import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import org.brechas.teccel.client.gin.ClientModule;
import org.brechas.teccel.client.presenter.HomePresenter;
import org.brechas.teccel.client.presenter.LayoutPresenter;
import org.brechas.teccel.client.presenter.LoginPresenter;

import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.gwt.inject.client.AsyncProvider;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	AsyncProvider<HomePresenter> getHomePresenter();
		
	AsyncProvider<LoginPresenter> getLoginPresenter();
	
	AsyncProvider<LayoutPresenter> getRootPresenter();

}
