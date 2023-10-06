package com.uzitec.clienteservico.ordemServico.application.service;

import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;

public interface OrdemServicoService {
	OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest);
	OrdemServicoResponse findOrdemServicoById(Long idOrdemServico);
	void findAllOrdemServico();
}
