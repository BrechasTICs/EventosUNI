package org.brechas.teccel.server.entity;

import java.util.UUID;

import org.brechas.teccel.shared.entity.ContactoDto;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
@Entity
public class Contacto extends BaseEntity{
	
	private static final String CLOUD_ENTITY_ID_PREFIX="CE:";
	private static final long serialVersionUID = 3851547942748641250L;

    @Index private String tipo;
	private String valor;

	public Contacto() {
		start();
		set_kindName("Contacto");
	}
	public ContactoDto getDto(){
		ContactoDto dto = new ContactoDto();
		dto.setTipo(tipo);
		dto.setValor(valor);
		return dto;
	}
	public void setDto(ContactoDto dto){
		tipo=dto.getTipo();
		valor=dto.getValor();
		id=CLOUD_ENTITY_ID_PREFIX+UUID.randomUUID().toString();
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public String getValor() {
		return valor;
	}
}
