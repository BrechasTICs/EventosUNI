package org.brechas.teccel.server.entity;

import java.util.UUID;

import org.brechas.teccel.shared.entity.ActividadDto;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;


@Entity
public class Actividad extends BaseEntity {

	private static final String CLOUD_ENTITY_ID_PREFIX="CE:";
	private static final long serialVersionUID = 5855797850227150066L;
	
    private String nombre;
	private String descripcion;
	@Index private String estado;
	private Integer capacidad;
	@Load private Ref<Lugar> lugar;
	@Load private Ref<Tiempo> tiempo;
	
	public Ref<Lugar> getLugar() {
		return lugar;
	}
	public void setLugar(Ref<Lugar> lugar) {
		this.lugar = lugar;
	}
	public Ref<Tiempo> getTiempo() {
		return tiempo;
	}
	public void setTiempo(Ref<Tiempo> tiempo) {
		this.tiempo = tiempo;
	}
	public Actividad() {
		start();
		set_kindName("Actividad");
	}
	public ActividadDto getDto(){
		ActividadDto dto = new ActividadDto();
		dto.setNombre(nombre);
		dto.setCapacidad(capacidad);
		dto.setDescripcion(descripcion);
		dto.setEstado(estado);
		return dto;
	}
	public void setDto(ActividadDto dto){
		id=CLOUD_ENTITY_ID_PREFIX+UUID.fromString(nombre+get_createdAt()).toString();
		nombre=dto.getNombre();
		capacidad=dto.getCapacidad();
		descripcion=dto.getDescripcion();
		estado=dto.getEstado();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public Integer getCapacidad() {
		return capacidad;
	}
}
