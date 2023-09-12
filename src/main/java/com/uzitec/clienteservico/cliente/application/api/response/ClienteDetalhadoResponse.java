package com.uzitec.clienteservico.cliente.application.api.response;

import java.util.UUID;

import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.cliente.domain.Sexo;

import lombok.Value;

@Value
public class ClienteDetalhadoResponse {
	private UUID idCliente;
	private String nomeCliente;
	private Sexo sexo;
	private String telefone;
	private String rua;
	private String bairro;
	private String numeroDaCasa;
	private String cidade;
	private String cpf;
	private String rg;

	public ClienteDetalhadoResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
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