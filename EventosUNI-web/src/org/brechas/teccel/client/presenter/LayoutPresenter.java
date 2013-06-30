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

public class LayoutPresenter extends
		Presenter<LayoutPresenter.MyView, LayoutPresenter.MyProxy> {

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<RevealContentHandler<?>>();
		
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetHeadContent = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetMenuContent = new Type<RevealContentHandler<?>>();
	
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetFootContent = new Type<RevealContentHandler<?>>();
	
	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_SetLoginContent = new Type<RevealContentHandler<?>>();

	@Inject
	LoginPresenter loginPresenter;
	
	@Inject
	HeaderPresenter headPresenter;
	
	@Inject
	FooterPresenter footPresenter;
	
	@Inject
	MenuHomePresenter menuPresenter;
		
	public interface MyView extends View {
	}

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<LayoutPresenter> {
	}

	@Inject
	public LayoutPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();

		setInSlot(SLOT_SetLoginContent, loginPresenter);
	//	setInSlot(SLOT_SetHeadContent, headPresenter);
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
