package com.uzitec.clienteservico.ordemServico.application.repository;

import java.util.List;

import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

public interface OrdemServicoRepository {
	OrdemServico saveOrdemServico(OrdemServico ordemServico);
	OrdemServico findByOrdemServicoById(Long idOrdemServico);
	List<OrdemServico> findAllOrdemServico();
}