package com.uzitec.clienteservico.Servico.application.api.request;

import java.math.BigDecimal;

import com.uzitec.clienteservico.Servico.domain.ServicoAExecutar;

import lombok.Value;

@Value
public class ServicoRequest {
	private ServicoAExecutar servicoExecutado;
	private BigDecimal ValorServico;
}
