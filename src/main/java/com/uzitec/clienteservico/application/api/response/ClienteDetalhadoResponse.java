package com.uzitec.clienteservico.application.api.response;

import com.uzitec.clienteservico.domain.Cliente;
import com.uzitec.clienteservico.domain.Sexo;

import lombok.Value;

@Value
public class ClienteDetalhadoResponse {
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