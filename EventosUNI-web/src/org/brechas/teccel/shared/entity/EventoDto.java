package org.brechas.teccel.shared.entity;


public class EventoDto implements Dto{

	private static final long serialVersionUID = 6846288418104539864L;
	private String nombre;
	private String descripcion;
	private String requisito;
	private String estado;
	private Integer asistente;
	private String observacion;
	private String imagenUrl;
	public EventoDto() {
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

	public String getImagenUrl() {
		return imagenUrl;
	}
}
