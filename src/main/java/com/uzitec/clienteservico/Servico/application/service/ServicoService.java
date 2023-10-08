package com.uzitec.clienteservico.Servico.application.service;

import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.Servico.application.api.response.ServicoResponse;

public interface ServicoService {
	ServicoResponse postServico(ServicoRequest servicoRequest);
}
