package org.brechas.teccel.client.action;

import com.gwtplatform.dispatch.shared.Result;
import java.lang.Boolean;

public class PublicarEventoActionResult implements Result {

	private Boolean exito;

	@SuppressWarnings("unused")
	private PublicarEventoActionResult() {
		// For serialization only
	}

	public PublicarEventoActionResult(Boolean exito) {
		this.exito = exito;
	}

	public Boolean getExito() {
		return exito;
	}
}
