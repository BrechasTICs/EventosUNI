package org.brechas.teccel.shared.entity;


public class OrganizadorDto implements Dto {

	private static final long serialVersionUID = 3145502731223640453L;
	private String nombre;
	private String descripcion;	
	
	public OrganizadorDto() {
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
