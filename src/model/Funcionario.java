package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario {

	@Id
	@Column(name = "id_funcionario")
	@NotNull
	private int id_funcionario;

	@Column(name = "nome_funcionario")
	@NotNull
	private String nome;

	@Column(name = "nascimento")
	@NotNull
	private LocalDate nascimento;

	@Column(name = "salario")
	@NotNull
	private float salario;

	@Column(name = "contato_funcionario")
	@NotNull
	private String contato;

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Funcionario [id_funcionario=" + id_funcionario + ", nome=" + nome + ", nascimento=" + nascimento
				+ ", salario=" + salario + ", contato=" + contato + "]";
	}

}
