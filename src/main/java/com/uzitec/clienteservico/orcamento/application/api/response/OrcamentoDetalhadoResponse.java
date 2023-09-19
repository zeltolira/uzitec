package com.uzitec.clienteservico.orcamento.application.api.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.uzitec.clienteservico.orcamento.domain.Marca;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecultar;
import com.uzitec.clienteservico.orcamento.domain.TipoProduto;

import lombok.Value;

@Value
public class OrcamentoDetalhadoResponse {
	private Long idOrcamento;
	private TipoProduto tipoProduto;
	private Marca marca;
	private ServicoAExecultar ServicoAExecultar;
	private BigDecimal valorOrcamento;
	private String observacao;
	private LocalDate dataOrcamento;
	private Integer garantia;
}