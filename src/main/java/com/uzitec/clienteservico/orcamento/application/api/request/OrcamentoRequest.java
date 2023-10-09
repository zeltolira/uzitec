package com.uzitec.clienteservico.orcamento.application.api.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.uzitec.clienteservico.orcamento.domain.Marca;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;
import com.uzitec.clienteservico.orcamento.domain.TipoProduto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class OrcamentoRequest {
	private TipoProduto tipoProduto;
	@NotNull
	private Marca marca;
	private ServicoAExecutar ServicoAExecultar;
	@NotNull
	private BigDecimal valorOrcamento;
	private String observacao;
	@NotNull
	private LocalDate dataOrcamento;
	@NotNull
	private Integer garantia;
	
}
