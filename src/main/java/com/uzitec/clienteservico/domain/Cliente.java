package com.uzitec.clienteservico.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@NotBlank
	private String nomeCliente;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@NotBlank
	private String tefone;
	@NotBlank
	private String rua;
	@NotBlank
	private String bairro;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	@NotBlank
	@CPF
	@Column(unique = true)
	private String cpf;
	@NotBlank
	@Column(unique = true)
	private String rg;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraultimaAlteracao;
	
	public Cliente() {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.sexo = sexo;
		this.tefone = tefone;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.cpf = cpf;
		this.rg = rg;
		this.dataHoraDoCadastro = dataHoraDoCadastro;
		this.dataHoraultimaAlteracao = dataHoraultimaAlteracao;
	}
	
	
}
