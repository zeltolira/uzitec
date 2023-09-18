package com.uzitec.clienteservico.orcamento.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoListReponse;
import com.uzitec.clienteservico.orcamento.application.api.response.OrcamentoResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/orcamento/{idCliente}")
public interface OrcamentoAPI {
	//TODO mudar nomeclatura ou tudo para portugues ou tudo para ingles
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	OrcamentoResponse postOrcamento(@RequestParam UUID idCliente, @Valid @RequestBody OrcamentoRequest orcamentoRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<OrcamentoListReponse> getTodosOrcamentoDoCliente(@RequestParam UUID idCliente);
	
	
}
