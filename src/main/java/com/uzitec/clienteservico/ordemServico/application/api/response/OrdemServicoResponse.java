package com.uzitec.clienteservico.ordemServico.application.api.response;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<OrdemServicoResponse> converte(List<OrdemServico> ordemServicos) {
		return ordemServicos.stream()
				.map(OrdemServicoResponse::new)
				.collect(Collectors.toList());
	}
}