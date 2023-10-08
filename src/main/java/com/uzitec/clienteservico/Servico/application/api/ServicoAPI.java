package com.uzitec.clienteservico.Servico.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.Servico.application.api.response.ServicoResponse;

import jakarta.validation.Valid;

@RequestMapping("/v1/servico")
public interface ServicoAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ServicoResponse postServico(@Valid @RequestBody ServicoRequest servicoRequest);

	@GetMapping(value = "/{idServico}")
	@ResponseStatus(code = HttpStatus.OK)
	ServicoResponse findServicoById(@PathVariable Long idServico);

	@GetMapping(value = "/allServicos")
	@ResponseStatus(code = HttpStatus.OK)
	List<ServicoResponse> findAllServico();

	@DeleteMapping(value = "/{idServico}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deleteServico(@PathVariable Long idServico);

}
