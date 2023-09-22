package com.uzitec.clienteservico.orcamento.application.api.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.uzitec.clienteservico.orcamento.domain.Marca;
import com.uzitec.clienteservico.orcamento.domain.Orcamento;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;
import com.uzitec.clienteservico.orcamento.domain.TipoProduto;

import lombok.Value;

@Value
public class OrcamentoDetalhadoResponse {
	private Long idOrcamento;
	private TipoProduto tipoProduto;
	private Marca marca;
	private ServicoAExecutar ServicoAExecultar;
	private BigDecimal valorOrcamento;
	private String observacao;
	private LocalDate dataOrcamento;
	private Integer garantia;

	public OrcamentoDetalhadoResponse(Orcamento orcamento) {
		this.idOrcamento = orcamento.getIdOrcamento();
		this.tipoProduto = orcamento.getTipoProduto();
		this.marca = orcamento.getMarca();
		this.ServicoAExecultar = orcamento.getServicoAExecultar();
		this.valorOrcamento = orcamento.getValorOrcamento();
		this.observacao = orcamento.getObservacao();
		this.dataOrcamento = orcamento.getDataOrcamento();
		this.garantia = orcamento.getGarantia();
	}
}