package com.uzitec.clienteservico.ordemServico.application.api.response;

import com.uzitec.clienteservico.orcamento.domain.Marca;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;
import com.uzitec.clienteservico.orcamento.domain.TipoProduto;
import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

import lombok.Value;

@Value
public class OrdemServicoResponse {

	private Long idOrdemServico;
	private TipoProduto tipoProduto;
	private Marca tipoMarca;
	private ServicoAExecutar servicoAExecutar;
	private String observacao;

	public OrdemServicoResponse(OrdemServico ordemServico) {
		this.idOrdemServico = ordemServico.getIdOrdemServico();
		this.tipoProduto = ordemServico.getTipoProduto();
		this.tipoMarca = ordemServico.getTipoMarca();
		this.servicoAExecutar = ordemServico.getServicoAExecutar();
		this.observacao = ordemServico.getObservacao();
	}

	
}
