package org.brechas.teccel.server.entity;

import java.util.UUID;

import org.brechas.teccel.shared.entity.TipoEventoDto;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
@Entity
public class TipoEvento extends BaseEntity {
	private static final String CLOUD_ENTITY_ID_PREFIX="CE:";
	private static final long serialVersionUID = -2904973194219586740L;
	private Boolean academico;
	private Boolean cultural;
	private Boolean social;
	private Boolean deportivo;
	private Boolean recreativo;
	@Index private Boolean mixto;
	
	public TipoEvento(){
		start();
		set_kindName("TipoEvento");		
	}
	public TipoEventoDto getDto(){
		TipoEventoDto dto = new TipoEventoDto();
		dto.setAcademico(academico);
		dto.setCultural(cultural);
		dto.setDeportivo(deportivo);
		dto.setMixto(mixto);
		dto.setRecreativo(recreativo);
		dto.setSocial(social);
		return dto;
	}
	public void setDto(TipoEventoDto dto){
		academico=dto.getAcademico();
		cultural=dto.getCultural();
		deportivo=dto.getDeportivo();
		mixto=dto.getMixto();
		recreativo=dto.getRecreativo();
		social=dto.getSocial();
		id=CLOUD_ENTITY_ID_PREFIX+UUID.fromString(""+mixto+academico+cultural+social+deportivo+recreativo).toString();
		
	}

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

	public void setAcademico(Boolean academico) {
		this.academico = academico;
	}

	public Boolean getAcademico() {
		return academico;
	}
}
