package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class LayoutMainPresenter extends
		Presenter<LayoutMainPresenter.MyView, LayoutMainPresenter.MyProxy> {

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetSesionContent = new Type<RevealContentHandler<?>>();
	
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetHeadContent = new Type<RevealContentHandler<?>>();
	
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<RevealContentHandler<?>>();
		
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetMenuContent = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetFootContent = new Type<RevealContentHandler<?>>();
	

	@Inject
	SesionPresenter sesionPresenter;
	
	@Inject
	HeaderPresenter headPresenter;
	
	@Inject
	FooterPresenter footPresenter;
	
	@Inject
	MenuAdminPresenter menuPresenter;
		
	public interface MyView extends View {
	}

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<LayoutMainPresenter> {
	}

	@Inject
	public LayoutMainPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void onReveal() {
		super.onReveal();

		setInSlot(SLOT_SetSesionContent, sesionPresenter);
		setInSlot(SLOT_SetHeadContent, headPresenter);
		setInSlot(SLOT_SetMenuContent, menuPresenter);
		setInSlot(SLOT_SetFootContent, footPresenter);
	}
	
	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
