package com.uzitec.clienteservico.ordemServico.application.service;

import java.util.List;

import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.request.PatchOrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;

import jakarta.validation.Valid;

public interface OrdemServicoService {
	OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest);
	OrdemServicoResponse findOrdemServicoById(Long idOrdemServico);
	List<OrdemServicoResponse> findAllOrdemServico();
	void patchOrdemServico(Long idOrdemServico, @Valid PatchOrdemServicoRequest patchOrdemServicoRequest);
}
