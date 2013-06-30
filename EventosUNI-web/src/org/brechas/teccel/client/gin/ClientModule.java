package org.brechas.teccel.client.gin;


import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import org.brechas.teccel.client.place.ClientPlaceManager;
import org.brechas.teccel.client.place.DefaultPlace;
import org.brechas.teccel.client.place.NameTokens;
import org.brechas.teccel.client.presenter.FooterPresenter;
import org.brechas.teccel.client.presenter.FooterView;
import org.brechas.teccel.client.presenter.HeaderPresenter;
import org.brechas.teccel.client.presenter.HeaderView;
import org.brechas.teccel.client.presenter.HomePresenter;
import org.brechas.teccel.client.presenter.HomeView;
import org.brechas.teccel.client.presenter.LayoutMainPresenter;
import org.brechas.teccel.client.presenter.LayoutMainView;
import org.brechas.teccel.client.presenter.LayoutPresenter;
import org.brechas.teccel.client.presenter.LayoutView;
import org.brechas.teccel.client.presenter.LoginPresenter;
import org.brechas.teccel.client.presenter.LoginView;
import org.brechas.teccel.client.presenter.MainPresenter;
import org.brechas.teccel.client.presenter.MainView;
import org.brechas.teccel.client.presenter.MenuAdminPresenter;
import org.brechas.teccel.client.presenter.MenuAdminView;
import org.brechas.teccel.client.presenter.MenuHomePresenter;
import org.brechas.teccel.client.presenter.MenuHomeView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);

		bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
				HomeView.class, HomePresenter.MyProxy.class);

		bindPresenter(MainPresenter.class, MainPresenter.MyView.class,
				MainView.class, MainPresenter.MyProxy.class);

		bindPresenter(LayoutPresenter.class, LayoutPresenter.MyView.class,
				LayoutView.class, LayoutPresenter.MyProxy.class);
		
		bindPresenter(LayoutMainPresenter.class,
				LayoutMainPresenter.MyView.class, LayoutMainView.class,
				LayoutMainPresenter.MyProxy.class);

		bindPresenterWidget(LoginPresenter.class, LoginPresenter.MyView.class,
				LoginView.class);
		
		bindPresenterWidget(HeaderPresenter.class,
				HeaderPresenter.MyView.class, HeaderView.class);

		bindPresenterWidget(FooterPresenter.class,
				FooterPresenter.MyView.class, FooterView.class);

		bindPresenterWidget(MenuAdminPresenter.class,
				MenuAdminPresenter.MyView.class, MenuAdminView.class);
	
		bindPresenterWidget(MenuHomePresenter.class,
				MenuHomePresenter.MyView.class, MenuHomeView.class);

	}
}
