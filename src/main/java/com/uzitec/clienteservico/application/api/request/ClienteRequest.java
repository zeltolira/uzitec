package com.uzitec.clienteservico.application.api.request;

import com.uzitec.clienteservico.domain.Sexo;

import lombok.Value;

@Value
public class ClienteRequest {

	private String nomeCliente;
	private Sexo sexo;
	private String tefone;
	private String rua;
	private String bairro;
	private String numero;
	private String cidade;
	private String cpf;
	private String rg;
}
