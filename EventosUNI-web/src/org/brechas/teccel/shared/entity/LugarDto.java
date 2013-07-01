package org.brechas.teccel.shared.entity;


public class LugarDto implements Dto {

	private static final long serialVersionUID = 9079405720737344230L;

	private String Pais;
	private String Region;
	private String Provincia;
	private String distrito;
	private String direccion;
	private String referencia;
	private boolean universidad;

	public LugarDto() {
	}

	public void setPais(String Pais) {
		this.Pais = Pais;
	}

	public void setRegion(String Region) {
		this.Region = Region;
	}

	public void setProvincia(String Provincia) {
		this.Provincia = Provincia;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getPais() {
		return Pais;
	}

	public String getRegion() {
		return Region;
	}

	public String getProvincia() {
		return Provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getReferencia() {
		return referencia;
	}

	public boolean isUniversidad() {
		return universidad;
	}

	public void setUniversidad(boolean universidad) {
		this.universidad = universidad;
	}
}
