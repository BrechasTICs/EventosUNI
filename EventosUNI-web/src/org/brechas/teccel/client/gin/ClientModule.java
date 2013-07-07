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
import org.brechas.teccel.client.presenter.LayoutPresenter;
import org.brechas.teccel.client.presenter.LayoutView;
import org.brechas.teccel.client.presenter.LoginPresenter;
import org.brechas.teccel.client.presenter.LoginView;
import org.brechas.teccel.client.presenter.MenuHomePresenter;
import org.brechas.teccel.client.presenter.MenuHomeView;
import org.brechas.teccel.client.presenter.PublishEventPresenter;
import org.brechas.teccel.client.presenter.PublishEventView;
import org.brechas.teccel.client.presenter.WidgetActividadPresenter;
import org.brechas.teccel.client.presenter.WidgetActividadView;
import org.brechas.teccel.client.presenter.WidgetOrganizadorPresenter;
import org.brechas.teccel.client.presenter.WidgetOrganizadorView;
import org.brechas.teccel.client.presenter.WidgetContactoPresenter;
import org.brechas.teccel.client.presenter.WidgetContactoView;
import org.brechas.teccel.client.presenter.ViewEventPresenter;
import org.brechas.teccel.client.presenter.ViewEventView;
import org.brechas.teccel.client.presenter.RegisterOrganizadorPresenter;
import org.brechas.teccel.client.presenter.RegisterOrganizadorView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);

		bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
				HomeView.class, HomePresenter.MyProxy.class);

		bindPresenter(LayoutPresenter.class, LayoutPresenter.MyView.class,
				LayoutView.class, LayoutPresenter.MyProxy.class);
		
		bindPresenterWidget(LoginPresenter.class, LoginPresenter.MyView.class,
				LoginView.class);
		
		bindPresenterWidget(HeaderPresenter.class,
				HeaderPresenter.MyView.class, HeaderView.class);

		bindPresenterWidget(FooterPresenter.class,
				FooterPresenter.MyView.class, FooterView.class);

		bindPresenterWidget(MenuHomePresenter.class,
				MenuHomePresenter.MyView.class, MenuHomeView.class);


		bindPresenter(PublishEventPresenter.class,
				PublishEventPresenter.MyView.class, PublishEventView.class,
				PublishEventPresenter.MyProxy.class);

		bindPresenterWidget(WidgetActividadPresenter.class,
				WidgetActividadPresenter.MyView.class,
				WidgetActividadView.class);

		bindPresenterWidget(WidgetOrganizadorPresenter.class,
				WidgetOrganizadorPresenter.MyView.class,
				WidgetOrganizadorView.class);

		bindPresenterWidget(WidgetContactoPresenter.class,
				WidgetContactoPresenter.MyView.class, WidgetContactoView.class);

		bindPresenter(ViewEventPresenter.class,
				ViewEventPresenter.MyView.class, ViewEventView.class,
				ViewEventPresenter.MyProxy.class);

		bindPresenter(RegisterOrganizadorPresenter.class,
				RegisterOrganizadorPresenter.MyView.class,
				RegisterOrganizadorView.class,
				RegisterOrganizadorPresenter.MyProxy.class);
	}
}
