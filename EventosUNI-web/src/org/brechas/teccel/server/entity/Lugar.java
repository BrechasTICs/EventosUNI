package org.brechas.teccel.server.entity;

import java.lang.String;
import java.util.UUID;

import org.brechas.teccel.shared.entity.LugarDto;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
@Entity
public class Lugar extends BaseEntity {
	private static final String CLOUD_ENTITY_ID_PREFIX="CE:";
	private static final long serialVersionUID = 9079405720737344230L;

    private String pais;
	private String region;
	private String provincia;
	private String distrito;
	private String direccion;
	private String referencia;
	@Index private boolean universidad;

	public Lugar() {
		start();
		set_kindName("Lugar");
	}
	public LugarDto getDto(){
		LugarDto dto = new LugarDto();
		dto.setDireccion(direccion);
		dto.setDistrito(distrito);
		dto.setPais(pais);
		dto.setProvincia(provincia);
		dto.setReferencia(referencia);
		dto.setRegion(region);
		dto.setUniversidad(universidad);
		return dto;
	}
	public void setDto(LugarDto dto){
		direccion=dto.getDireccion();
		distrito=dto.getDistrito();
		pais=dto.getPais();
		provincia=dto.getProvincia();
		referencia=dto.getReferencia();
		region=dto.getRegion();
		universidad=dto.isUniversidad();
		id=CLOUD_ENTITY_ID_PREFIX+UUID.randomUUID().toString();
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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
		return pais;
	}

	public String getRegion() {
		return region;
	}

	public String getProvincia() {
		return provincia;
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
