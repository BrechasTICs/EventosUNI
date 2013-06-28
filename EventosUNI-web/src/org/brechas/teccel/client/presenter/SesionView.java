package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SesionView extends ViewImpl implements SesionPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, SesionView> {
	}

	@UiField Button cerrarButton;
	
	@Inject
	public SesionView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	public Button getCerrarButton() {
		return cerrarButton;
	}
}
