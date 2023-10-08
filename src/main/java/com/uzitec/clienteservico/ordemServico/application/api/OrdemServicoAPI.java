package com.uzitec.clienteservico.ordemServico.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.request.PatchOrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/ordemServico")
public interface OrdemServicoAPI {

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	OrdemServicoResponse saveOrdemServico(@Valid @RequestBody OrdemServicoRequest ordemServicoRequest);

	@GetMapping(value = "/{idOrdemServico}")
	@ResponseStatus(value = HttpStatus.OK)
	OrdemServicoResponse findOrdemServicoById(@Valid Long idOrdemServico);

	@GetMapping(value = "/allOrdemServico")
	@ResponseStatus(value = HttpStatus.OK)
	List<OrdemServicoResponse> findAllOrdemServico();
	
	@PatchMapping(value = "/{idOrdemServico}")
	@ResponseStatus(value = HttpStatus.OK)
	void patchOrdemServico (@PathVariable Long idOrdemServico, @Valid @RequestBody PatchOrdemServicoRequest patchOrdemServicoRequest);	
	
	
}
