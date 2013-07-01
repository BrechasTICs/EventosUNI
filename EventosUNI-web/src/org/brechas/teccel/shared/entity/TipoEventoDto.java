package org.brechas.teccel.shared.entity;

public class TipoEventoDto implements Dto {

	private static final long serialVersionUID = -2904973194219586740L;

	private Boolean academico;
	private Boolean cultural;
	private Boolean social;
	private Boolean deportivo;
	private Boolean recreativo;
	private Boolean mixto;

	public Boolean getCultural() {
		return cultural;
	}

	public void setCultural(Boolean cultural) {
		this.cultural = cultural;
	}

	public Boolean getSocial() {
		return social;
	}

	public void setSocial(Boolean social) {
		this.social = social;
	}

	public Boolean getDeportivo() {
		return deportivo;
	}

	public void setDeportivo(Boolean deportivo) {
		this.deportivo = deportivo;
	}

	public Boolean getRecreativo() {
		return recreativo;
	}

	public void setRecreativo(Boolean recreativo) {
		this.recreativo = recreativo;
	}

	public Boolean getMixto() {
		return mixto;
	}

	public void setMixto(Boolean mixto) {
		this.mixto = mixto;
	}

	public TipoEventoDto() {
	}

	public void setAcademico(Boolean academico) {
		this.academico = academico;
	}

	public Boolean getAcademico() {
		return academico;
	}
}
