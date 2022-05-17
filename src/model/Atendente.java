package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "atendente")
public class Atendente extends Funcionario {

	@Column(name = "hr_entrada")
	@NotNull
	private LocalDateTime hr_entrada;

	@Column(name = "hr_saida")
	@NotNull
	private LocalDateTime hr_saida;

	@Column(name = "email_atendente")
	@NotNull
	private String email;

	public LocalDateTime getHr_entrada() {
		return hr_entrada;
	}

	public void setHr_entrada(LocalDateTime hr_entrada) {
		this.hr_entrada = hr_entrada;
	}

	public LocalDateTime getHr_saida() {
		return hr_saida;
	}

	public void setHr_saida(LocalDateTime hr_saida) {
		this.hr_saida = hr_saida;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Atendente [hr_entrada=" + hr_entrada + ", hr_saida=" + hr_saida + ", email=" + email + "]";
	}

}
