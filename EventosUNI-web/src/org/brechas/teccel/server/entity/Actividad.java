package org.brechas.teccel.server.entity;

import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;


import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;
@Entity
public class Actividad extends BaseEntity {

	private static final long serialVersionUID = 5855797850227150066L;

    @Id Long id;

	private String nombre;
	private String descripcion;
	private String estado;
	private Integer capacidad;
	@Load Ref<Lugar> lugar;
	@Load Ref<Tiempo> tiempo;

	public Actividad() {
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
