package org.brechas.teccel.shared.entity;

public class ContactoDto implements Dto{

	private static final long serialVersionUID = 3851547942748641250L;

    private String tipo;
	private String valor;

	public ContactoDto() {
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
