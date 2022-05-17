package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "entregador")
public class Entregador extends Funcionario {

	@Column(name = "numero_cnh")
	@NotNull
	private int numero;
	
	@Column(name = "categoria_cnh")
	@NotNull
	private String categoria;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Entregador [numero=" + numero + ", categoria=" + categoria + "]";
	}

}
