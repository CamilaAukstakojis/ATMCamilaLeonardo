package main.java;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MinhaEntidade {
	@Id
	@GeneratedValue
	private Long id;
	private String texto;
	private int numero;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

}
