package com.uzitec.clienteservico.Servico.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	private Long idServico;
	private ServicoAExecutar servicoExecutado;
	private BigDecimal ValorServico;
	private TipoPagamento tipoPagamento;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	@JsonIgnore
	private Funcionario funcionario;
}
