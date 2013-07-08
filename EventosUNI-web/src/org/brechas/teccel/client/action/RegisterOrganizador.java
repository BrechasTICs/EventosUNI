package org.brechas.teccel.client.action;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.ActionImpl;
import org.brechas.teccel.client.action.RegisterOrganizadorResult;
import org.brechas.teccel.shared.entity.ContactoDto;
import org.brechas.teccel.shared.entity.OrganizadorDto;

import java.util.ArrayList;
import java.util.List;

public class RegisterOrganizador extends ActionImpl<RegisterOrganizadorResult> {

	private OrganizadorDto organizador;
	private List<ContactoDto> listcontacto= new ArrayList<ContactoDto>();
	private String request;
	
	@SuppressWarnings("unused")
	@Inject
	public RegisterOrganizador() {
		// For serialization only
	}

	public RegisterOrganizador(OrganizadorDto organizador, List<ContactoDto> listcontacto, String request) {
		this.organizador = organizador;
		this.listcontacto = listcontacto;
		this.request=request;
	}
	
	public OrganizadorDto getOrganizador() {
		return organizador;
	}

	public List<ContactoDto> getListContacto() {
		return listcontacto;
	}
	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getRequest() {
		return request;
	}

	public List<ContactoDto> getListcontacto() {
		return listcontacto;
	}

	public void setListcontacto(List<ContactoDto> listcontacto) {
		this.listcontacto = listcontacto;
	}

	public void setOrganizador(OrganizadorDto organizador) {
		this.organizador = organizador;
	}

	public void setRequest(String request) {
		this.request = request;
	}
}
