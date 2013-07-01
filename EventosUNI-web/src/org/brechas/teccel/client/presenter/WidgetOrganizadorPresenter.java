package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;

public class WidgetOrganizadorPresenter extends
		PresenterWidget<WidgetOrganizadorPresenter.MyView> {

	public interface MyView extends View {
	}

	@Inject
	public WidgetOrganizadorPresenter(final EventBus eventBus, final MyView view) {
		super(eventBus, view);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

	@Override
	protected void onReset() {
		super.onReset();
	}
}
