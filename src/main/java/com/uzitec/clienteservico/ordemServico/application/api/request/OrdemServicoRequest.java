package com.uzitec.clienteservico.ordemServico.application.api.request;

import java.time.LocalDate;

import com.uzitec.clienteservico.orcamento.domain.Marca;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;
import com.uzitec.clienteservico.orcamento.domain.TipoProduto;

import lombok.Value;

@Value
public class OrdemServicoRequest {

	private Long idOrdemServico;
	private TipoProduto tipoProduto;
	private Marca tipoMarca;
	private ServicoAExecutar servicoAExecutar;
	private String observacao;
	private LocalDate dataEntrega;
	
}
