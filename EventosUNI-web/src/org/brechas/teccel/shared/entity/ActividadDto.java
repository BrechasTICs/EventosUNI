package org.brechas.teccel.shared.entity;

public class ActividadDto implements Dto{

	private static final long serialVersionUID = 5855797850227150066L;
	private String nombre;
	private String descripcion;
	private String estado;
	private Integer capacidad;

	public ActividadDto() {
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
