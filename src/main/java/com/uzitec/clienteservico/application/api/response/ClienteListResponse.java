package com.uzitec.clienteservico.application.api.response;

import java.util.List;
import java.util.stream.Collectors;

import com.uzitec.clienteservico.domain.Cliente;
import com.uzitec.clienteservico.domain.Sexo;

import lombok.Value;

@Value
public class ClienteListResponse {
	private String nomeCliente;
	private Sexo sexo;
	private String telefone;
	private String rua;
	private String bairro;
	private String numeroDaCasa;
	private String cidade;
	private String cpf;
	private String rg;
	
	
	public static List<ClienteListResponse> converte(List<Cliente> clientes) {
		return clientes.stream()
				.map(ClienteListResponse::new)
				.collect(Collectors.toList());
	}


	public ClienteListResponse(Cliente cliente) {
		this.nomeCliente = cliente.getNomeCliente();
		this.sexo = cliente.getSexo();
		this.telefone = cliente.getTelefone();
		this.rua = cliente.getRua();
		this.bairro = cliente.getBairro();
		this.numeroDaCasa = cliente.getNumeroDaCasa();
		this.cidade = cliente.getCidade();
		this.cpf = cliente.getCpf();
		this.rg = cliente.getRg();
	}
	
	
}
