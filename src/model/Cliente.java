package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "cpf")
	@NotNull
	private String cpf;

	@Column(name = "nome_cliente")
	@NotNull
	private String nome;

	@Column(name = "contato_cliente")
	@NotNull
	private String contato;

	@Column(name = "email_cliente")
	@NotNull
	private String email;

	@Column(name = "pronome")
	@NotNull
	private String pronome;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPronome() {
		return pronome;
	}

	public void setPronome(String pronome) {
		this.pronome = pronome;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contato=" + contato + ", email=" + email + ", pronome="
				+ pronome + "]";
	}

}
