package org.brechas.teccel.server.entity;

import java.io.Serializable;
import java.lang.String;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Contacto extends BaseEntity{

	private static final long serialVersionUID = 3851547942748641250L;

    @Id Long id;

	private String tipo;
	private String valor;

	public Contacto() {
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
