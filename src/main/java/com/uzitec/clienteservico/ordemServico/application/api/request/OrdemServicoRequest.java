package com.uzitec.clienteservico.ordemServico.application.api.request;

import java.util.UUID;

import com.uzitec.clienteservico.ordemServico.domain.Marca;
import com.uzitec.clienteservico.ordemServico.domain.ServicoAExecutar;
import com.uzitec.clienteservico.ordemServico.domain.TipoProduto;

import lombok.Value;

@Value
public class OrdemServicoRequest {

	private TipoProduto tipoProduto;
	private Marca tipoMarca;
	private ServicoAExecutar servicoAExecutar;
	private String observacao;
	private UUID idFuncionario;
	private Long idOrcamento;
	private Long idServico;
		
}
