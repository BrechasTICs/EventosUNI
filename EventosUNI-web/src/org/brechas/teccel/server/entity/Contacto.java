package org.brechas.teccel.server.entity;

import java.util.UUID;

import org.brechas.teccel.shared.entity.ContactoDto;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
@Entity
public class Contacto extends BaseEntity{
	
	private static final String CLOUD_ENTITY_ID_PREFIX="CE:";
	private static final long serialVersionUID = 3851547942748641250L;

    @Index private String tipo;
	@Index private String valor;
	@Load private Ref<Organizador> organizador;

	public Ref<Organizador> getOrganizador() {
		return organizador;
	}
	public void setOrganizador(Ref<Organizador> organizador) {
		this.organizador = organizador;
	}
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
