package com.uzitec.clienteservico.Servico.application.api.response;

import com.uzitec.clienteservico.orcamento.domain.Marca;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;
import com.uzitec.clienteservico.orcamento.domain.TipoProduto;

import lombok.Value;

@Value
public class OrdemServicoResponse {

	private Long idOrdemServico;
	private TipoProduto tipoProduto;
	private Marca tipoMarca;
	private ServicoAExecutar servicoAExecutar;
	private String observacao;
}
