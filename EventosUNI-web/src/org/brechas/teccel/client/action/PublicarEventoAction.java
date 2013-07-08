package org.brechas.teccel.client.action;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.dispatch.shared.ActionImpl;
import org.brechas.teccel.client.action.PublicarEventoActionResult;
import org.brechas.teccel.shared.entity.ActividadDto;
import org.brechas.teccel.shared.entity.ContactoDto;
import org.brechas.teccel.shared.entity.EventoDto;
import org.brechas.teccel.shared.entity.LugarDto;
import org.brechas.teccel.shared.entity.OrganizadorDto;
import org.brechas.teccel.shared.entity.TiempoDto;
import org.brechas.teccel.shared.entity.TipoEventoDto;

public class PublicarEventoAction extends
		ActionImpl<PublicarEventoActionResult> {

	private List<OrganizadorDto> listOrganizador=new ArrayList<OrganizadorDto>();
	private List<List<ContactoDto>> listContacto=new ArrayList<List<ContactoDto>>();
	private List<ActividadDto> listActividad=new ArrayList<ActividadDto>();
	private List<LugarDto> listLugar=new ArrayList<LugarDto>();
	private List<TiempoDto> listTiempo=new ArrayList<TiempoDto>();
	private EventoDto evento;
	private TipoEventoDto tipoEvento;
	private String request;
	public PublicarEventoAction() {
	}
	public List<OrganizadorDto> getListOrganizador() {
		return listOrganizador;
	}
	public void setListOrganizador(List<OrganizadorDto> listOrganizador) {
		this.listOrganizador = listOrganizador;
	}
	public List<ActividadDto> getListActividad() {
		return listActividad;
	}
	public void setListActividad(List<ActividadDto> listActividad) {
		this.listActividad = listActividad;
	}
	public List<LugarDto> getListLugar() {
		return listLugar;
	}
	public void setListLugar(List<LugarDto> listLugar) {
		this.listLugar = listLugar;
	}
	public List<TiempoDto> getListTiempo() {
		return listTiempo;
	}
	public void setListTiempo(List<TiempoDto> listTiempo) {
		this.listTiempo = listTiempo;
	}
	public EventoDto getEvento() {
		return evento;
	}
	public void setEvento(EventoDto evento) {
		this.evento = evento;
	}
	public TipoEventoDto getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(TipoEventoDto tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public List<List<ContactoDto>> getListContacto() {
		return listContacto;
	}
	public void setListContacto(List<List<ContactoDto>> listContacto) {
		this.listContacto = listContacto;
	}
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	@Override
	public boolean isSecured() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
