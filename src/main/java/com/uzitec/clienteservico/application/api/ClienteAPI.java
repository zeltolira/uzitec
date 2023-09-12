package com.uzitec.clienteservico.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.application.api.response.ClienteDetalhadoResponse;
import com.uzitec.clienteservico.application.api.response.ClienteListResponse;
import com.uzitec.clienteservico.application.api.response.ClienteResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/cliente")
public interface ClienteAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ClienteResponse postCliente(@Valid @RequestBody ClienteRequest clienteRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteListResponse> getTodosClientes();
	
	@GetMapping(value = "/{idCliente}")
	@ResponseStatus(code = HttpStatus.OK)
	ClienteDetalhadoResponse getClientePorId(@Valid @RequestBody UUID idCliente);;
	
}
