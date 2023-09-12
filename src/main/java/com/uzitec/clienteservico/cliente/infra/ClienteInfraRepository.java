package com.uzitec.clienteservico.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.uzitec.clienteservico.cliente.application.repository.ClienteRepository;
import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

	private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - salva");
		clienteSpringDataJPARepository.save(cliente);
		log.info("[finaliza] ClienteInfraRepository - salva");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[inicia] ClienteInfraRepository - buscaTodosClientes");
		List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
		log.info("[finaliza] ClienteInfraRepository - buscaTodosClientes");
		return todosClientes;
	}

	@Override
	public Cliente buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteInfraRepository - buscaClientePorId");
		Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
				.orElseThrow(()->APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
		log.info("[finaliza] ClienteInfraRepository - buscaClientePorId");
		return cliente;
	}

	@Override
	public void deletaCliente(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - deletaCliente");
		clienteSpringDataJPARepository.delete(cliente);
		log.info("[finaliza] ClienteInfraRepository - deletaCliente");
		
	}

}
