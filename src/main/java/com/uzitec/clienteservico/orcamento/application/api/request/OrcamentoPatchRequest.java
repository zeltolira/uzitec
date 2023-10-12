package com.uzitec.clienteservico.orcamento.application.api.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.uzitec.clienteservico.orcamento.domain.Marca;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;
import com.uzitec.clienteservico.orcamento.domain.TipoProduto;

import lombok.Value;

@Value
public class OrcamentoPatchRequest {
	private TipoProduto tipoProduto;
	private Marca marca;
	private ServicoAExecutar servicoAExecultar;
	private BigDecimal valorOrcamento;
	private String observacao;
	private LocalDate dataOrcamento;
	private Integer garantia;
}
