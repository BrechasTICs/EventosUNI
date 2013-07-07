package org.brechas.teccel.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import java.lang.String;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;

public class EmailEvent extends GwtEvent<EmailEvent.EmailHandler> {

	public static Type<EmailHandler> TYPE = new Type<EmailHandler>();
	private String email;

	public interface EmailHandler extends EventHandler {
		void onEmail(EmailEvent event);
	}

	public interface EmailHasHandlers extends HasHandlers {
		HandlerRegistration addEmailHandler(EmailHandler handler);
	}

	@Inject
	public EmailEvent() {		
	}
	
	public EmailEvent(String email) {
		this.email = email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	protected void dispatch(EmailHandler handler) {
		handler.onEmail(this);
	}

	@Override
	public Type<EmailHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<EmailHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source, String email) {
		source.fireEvent(new EmailEvent(email));
	}
}
