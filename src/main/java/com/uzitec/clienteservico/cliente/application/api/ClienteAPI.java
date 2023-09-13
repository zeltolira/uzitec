package com.uzitec.clienteservico.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.cliente.application.api.request.ClienteAlteracaoRequest;
import com.uzitec.clienteservico.cliente.application.api.request.ClienteRequest;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteDetalhadoResponse;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteListResponse;
import com.uzitec.clienteservico.cliente.application.api.response.ClienteResponse;

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
	ClienteDetalhadoResponse getClientePorId(@PathVariable UUID idCliente);
	
	@PatchMapping(value = "/{idCliente}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void alteraClientePorId(@PathVariable UUID idCliente, @Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest);
		
	@DeleteMapping(value = "/{idCliente}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaClientePorId(@PathVariable UUID idCliente);
	
	@GetMapping(value = "/cpf")
	@ResponseStatus(code = HttpStatus.OK)
	ClienteDetalhadoResponse getClientePorCpf(@RequestParam String cpf);
	
}