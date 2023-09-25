package com.uzitec.clienteservico.funcionario.domain;

import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uzitec.clienteservico.funcionario.application.api.request.AlteraFuncionarioRequest;
import com.uzitec.clienteservico.funcionario.application.api.request.FuncionarioRequest;
import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idFuncionario;
	@NotBlank(message = "Campo Obrigatório")
	private String nomeFuncionario;
	@NotBlank(message = "Campo Obrigatório")
	@CPF
	@Column(unique = true)
	private String cpf;
	private String celular;
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "funcionario")
//	@JsonIgnore
//	private List<Servico> servicos;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "funcionario")
	@JsonIgnore
	private List<OrdemServico> ordemServico;
	
	public Funcionario(FuncionarioRequest funcionarioRequest) {
		this.nomeFuncionario = funcionarioRequest.getNomeFuncionario();
		this.cpf = funcionarioRequest.getCpf();
		this.celular = funcionarioRequest.getCelular();
		this.cargo = funcionarioRequest.getCargo();
	}

	public void altera(AlteraFuncionarioRequest alteraFuncionarioRequest) {
		this.nomeFuncionario = alteraFuncionarioRequest.getNomeFuncionario();
		this.cpf = alteraFuncionarioRequest.getCpf();
		this.celular = alteraFuncionarioRequest.getCelular();
		this.cargo = alteraFuncionarioRequest.getCargo();
		
	}
}