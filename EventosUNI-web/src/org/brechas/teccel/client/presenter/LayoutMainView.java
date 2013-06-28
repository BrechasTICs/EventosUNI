package org.brechas.teccel.client.presenter;

import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class LayoutMainView extends ViewImpl implements
		LayoutMainPresenter.MyView {

	
	@UiField HTMLPanel mainContentPanel;
	@UiField HTMLPanel headContentPanel;
	@UiField HTMLPanel footContentPanel;
	@UiField HTMLPanel sesionContentPanel;
	@UiField HTMLPanel menuContentPanel;
	
	private final Widget widget;

	public interface Binder extends UiBinder<Widget, LayoutMainView> {
	}

	@Inject
	public LayoutMainView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == LayoutMainPresenter.SLOT_SetMainContent)
		{			
			setMainContent(content);
		}
 		else if (slot == LayoutMainPresenter.SLOT_SetSesionContent)
		{
			setSesionContent(content);
		}
 		else if (slot == LayoutMainPresenter.SLOT_SetHeadContent)
		{
			setHeadContent(content);
		}
 		else if (slot == LayoutMainPresenter.SLOT_SetMenuContent)
		{
			setMenuContent(content);
		}
 		else if (slot == LayoutMainPresenter.SLOT_SetFootContent)
		{
			setFootContent(content);
		}
 		else
		{
			super.setInSlot(slot, content);
		}
	}
	
	private void setMainContent(Widget content) 
	{
	    mainContentPanel.clear();
	    if (content != null) 
	    {
	      mainContentPanel.add(content);
	    }
	}

	private void setSesionContent(Widget content)
	{
		sesionContentPanel.clear();
		if (content != null)
		{
			sesionContentPanel.add(content);
		}		
	}
	
	private void setHeadContent(Widget content)
	{
		headContentPanel.clear();
		if (content != null)
		{
			headContentPanel.add(content);
		}		
	}
	
	private void setMenuContent(Widget content)
	{
		menuContentPanel.clear();
		if (content != null)
		{
			menuContentPanel.add(content);
		}		
	}
	
	private void setFootContent(Widget content)
	{
		footContentPanel.clear();
		if (content != null)
		{
			footContentPanel.add(content);
		}		
	}
	
}
