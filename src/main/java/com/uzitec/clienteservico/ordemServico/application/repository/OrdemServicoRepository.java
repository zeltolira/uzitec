package com.uzitec.clienteservico.ordemServico.application.repository;

import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

public interface OrdemServicoRepository {
	OrdemServico saveOrdemServico(OrdemServico ordemServico);
}