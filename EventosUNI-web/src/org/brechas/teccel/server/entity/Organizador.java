package org.brechas.teccel.server.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.brechas.teccel.shared.entity.OrganizadorDto;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
@Entity
public class Organizador extends BaseEntity {
	private static final String CLOUD_ENTITY_ID_PREFIX="CE:";
	private static final long serialVersionUID = 3145502731223640453L;

    @Index private String nombre;
	private String descripcion;	
	@Load private List<Ref<Contacto>> contacto = new ArrayList<Ref<Contacto>>();
	@Load private List<Ref<Evento>> evento = new ArrayList<Ref<Evento>>();

	public List<Ref<Contacto>> getContacto() {
		return contacto;
	}
	public void setContacto(List<Ref<Contacto>> contacto) {
		this.contacto = contacto;
	}
	public List<Ref<Evento>> getEvento() {
		return evento;
	}
	public void setEvento(List<Ref<Evento>> evento) {
		this.evento = evento;
	}
	public Organizador() {
		start();
		set_kindName("Organizador");
	}
	public OrganizadorDto getDto(){
		OrganizadorDto dto = new OrganizadorDto();
		dto.setDescripcion(descripcion);
		dto.setNombre(nombre);
		return dto;
	}
	public void setDto(OrganizadorDto dto){
		nombre=dto.getNombre();
		descripcion=dto.getDescripcion();
		id=CLOUD_ENTITY_ID_PREFIX+UUID.randomUUID().toString();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
