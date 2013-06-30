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
public class Evento extends BaseEntity {

	private static final long serialVersionUID = 6846288418104539864L;

    @Id Long id;

	private String nombre;
	private String descripcion;
	private String requisito;
	private String tipo;
	private String estado;
	private Integer asistente;
	private String observacion;
	private String imagenBlobKey;
	private String imagenUrl;

	@Load List<Ref<Actividad>> actividad = new ArrayList<Ref<Actividad>>();

	public Evento() {
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

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
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
