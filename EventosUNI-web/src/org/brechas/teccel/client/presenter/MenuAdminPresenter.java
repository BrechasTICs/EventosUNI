package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;

public class MenuAdminPresenter extends
		PresenterWidget<MenuAdminPresenter.MyView> {

	public interface MyView extends View {
	}

	@Inject
	public MenuAdminPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
