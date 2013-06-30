package org.brechas.teccel.server.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;
@Entity
public class Organizador extends BaseEntity {

	private static final long serialVersionUID = 3145502731223640453L;

    @Id Long id;

	private String nombre;
	private String descripcion;	
	@Load List<Ref<Contacto>> contacto = new ArrayList<Ref<Contacto>>();
	@Load List<Ref<Evento>> evento = new ArrayList<Ref<Evento>>();

	public Organizador() {
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
