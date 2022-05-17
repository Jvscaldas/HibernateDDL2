package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "atendimento")
public class Atendimento {

	@Id
	@ManyToOne
	@JoinColumn(name = "cpf_cliente")
	@NotNull
	private Cliente cliente;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	@NotNull
	private Funcionario funcionario;

	@Column(name = "dt_atendimento")
	@NotNull
	private LocalDate dt_atendimento;

	@Column(name = "hr_atendimento")
	@NotNull
	private LocalDateTime hr_atendimento;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getDt_atendimento() {
		return dt_atendimento;
	}

	public void setDt_atendimento(LocalDate dt_atendimento) {
		this.dt_atendimento = dt_atendimento;
	}

	public LocalDateTime getHr_atendimento() {
		return hr_atendimento;
	}

	public void setHr_atendimento(LocalDateTime hr_atendimento) {
		this.hr_atendimento = hr_atendimento;
	}

	@Override
	public String toString() {
		return "Atendimento [cliente=" + cliente + ", funcionario=" + funcionario + ", dt_atendimento=" + dt_atendimento
				+ ", hr_atendimento=" + hr_atendimento + "]";
	}

}
