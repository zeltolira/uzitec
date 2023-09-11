package com.uzitec.clienteservico.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.application.api.response.ClienteResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/cliente")
public interface ClienteAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ClienteResponse postCliente(@Valid @RequestBody ClienteRequest clienteRequest);
}
