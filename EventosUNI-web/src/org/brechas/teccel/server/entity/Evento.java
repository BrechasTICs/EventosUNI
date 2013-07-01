package org.brechas.teccel.server.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.brechas.teccel.shared.entity.EventoDto;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Evento extends BaseEntity {
	private static final String CLOUD_ENTITY_ID_PREFIX="CE:";
	private static final long serialVersionUID = 6846288418104539864L;

	@Index private String nombre;
	private String descripcion;
	private String requisito;
	@Load
	private Ref<TipoEvento> tipoEvento;
	@Index
	private String estado;
	private Integer asistente;
	private String observacion;
	private String imagenBlobKey;
	private String imagenUrl;
	@Load
	private List<Ref<Actividad>> actividad = new ArrayList<Ref<Actividad>>();
	@Load
	private List<Ref<Organizador>> organizador = new ArrayList<Ref<Organizador>>();

	public Ref<TipoEvento> getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(Ref<TipoEvento> tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public List<Ref<Actividad>> getActividad() {
		return actividad;
	}
	public void setActividad(List<Ref<Actividad>> actividad) {
		this.actividad = actividad;
	}
	public List<Ref<Organizador>> getOrganizador() {
		return organizador;
	}
	public void setOrganizador(List<Ref<Organizador>> organizador) {
		this.organizador = organizador;
	}
	public Evento() {
		start();
		set_kindName("Evento");
	}
	public EventoDto getDto(){
		EventoDto dto = new EventoDto();
		dto.setAsistente(asistente);
		dto.setDescripcion(descripcion);
		dto.setEstado(estado);
		dto.setImagenUrl(imagenUrl);
		dto.setNombre(nombre);
		dto.setRequisito(requisito);
		dto.setObservacion(observacion);
		return dto;
	}
	public void setDto(EventoDto dto){
		asistente=dto.getAsistente();
		descripcion=dto.getDescripcion();
		estado=dto.getEstado();
		imagenUrl=dto.getImagenUrl();
		nombre=dto.getNombre();
		requisito=dto.getRequisito();
		observacion=dto.getObservacion();
		id=CLOUD_ENTITY_ID_PREFIX+UUID.fromString(nombre+get_createdAt()).toString();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setAsistente(Integer asistente) {
		this.asistente = asistente;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public void setImagenBlobKey(String imagenBlobKey) {
		this.imagenBlobKey = imagenBlobKey;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getRequisito() {
		return requisito;
	}

	public String getEstado() {
		return estado;
	}

	public Integer getAsistente() {
		return asistente;
	}

	public String getObservacion() {
		return observacion;
	}

	public String getImagenBlobKey() {
		return imagenBlobKey;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}
}
