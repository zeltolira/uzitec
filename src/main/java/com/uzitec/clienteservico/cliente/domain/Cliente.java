package com.uzitec.clienteservico.cliente.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import com.uzitec.clienteservico.cliente.application.api.request.ClienteAlteracaoRequest;
import com.uzitec.clienteservico.cliente.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.orcamento.domain.Orcamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idCliente;
	@NotBlank(message = "Campo obrigatório!")
	private String nomeCliente;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@NotBlank
	private String telefone;
	@NotBlank
	private String rua;
	@NotBlank
	private String bairro;
	@NotBlank
	private String numeroDaCasa;
	@NotBlank
	private String cidade;
	@NotBlank(message = "Campo obrigatório!")
	@CPF
	@Column(unique = true)
	private String cpf;
	@NotBlank
	@Column(unique = true)
	private String rg;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraultimaAlteracao;
	
	
	@OneToMany(mappedBy = "cliente")
	private List<Orcamento> orcamento;


	public Cliente(ClienteRequest clienteRequest) {
		this.nomeCliente = clienteRequest.getNomeCliente();
		this.sexo = clienteRequest.getSexo();
		this.telefone = clienteRequest.getTelefone();
		this.rua = clienteRequest.getRua();
		this.bairro = clienteRequest.getBairro();
		this.numeroDaCasa = clienteRequest.getNumeroDaCasa();
		this.cidade = clienteRequest.getCidade();
		this.cpf = clienteRequest.getCpf();
		this.rg = clienteRequest.getRg();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(ClienteAlteracaoRequest clienteRequest) {
		this.nomeCliente = clienteRequest.getNomeCliente();
		this.sexo = clienteRequest.getSexo();
		this.telefone = clienteRequest.getTelefone();
		this.rua = clienteRequest.getRua();
		this.bairro = clienteRequest.getBairro();
		this.numeroDaCasa = clienteRequest.getNumeroDaCasa();
		this.cidade = clienteRequest.getCidade();
		this.dataHoraultimaAlteracao = LocalDateTime.now();
	}
}