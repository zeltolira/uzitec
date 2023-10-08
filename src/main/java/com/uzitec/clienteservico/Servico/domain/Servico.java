package com.uzitec.clienteservico.Servico.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "servico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idServico;
	@NotBlank
	private ServicoAExecutar servicoExecutado;
	@NotNull
	private BigDecimal ValorServico;
	@NotNull
	private TipoPagamento tipoPagamento;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	@JsonIgnore
	private Funcionario funcionario;

	public Servico(ServicoRequest servicoRequest) {
		this.servicoExecutado = servicoRequest.getServicoExecutado();
		this.ValorServico = servicoRequest.getValorServico();
	}


}
