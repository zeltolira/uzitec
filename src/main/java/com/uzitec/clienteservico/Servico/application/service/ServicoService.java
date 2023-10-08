package com.uzitec.clienteservico.Servico.application.service;

import java.util.List;

import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.Servico.application.api.response.ServicoResponse;

public interface ServicoService {
	ServicoResponse postServico(ServicoRequest servicoRequest);
	ServicoResponse findServicoById(Long idServico);
	List<ServicoResponse> findAllServico();
	void deleteServico(Long idServico);
	void patchServico(Long idServico, ServicoRequest servicoRequest);
}
