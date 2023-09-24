package com.uzitec.clienteservico.ordemServico.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;

import jakarta.validation.Valid;

@RequestMapping("/v1/ordemServico")
public interface OrdemServicoAPI {

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	OrdemServicoResponse postOrdemServico(@Valid @RequestBody OrdemServicoRequest ordemServicoRequest);
}
