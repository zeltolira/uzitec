package com.uzitec.clienteservico.Servico.application.api.request;

import java.math.BigDecimal;

import com.uzitec.clienteservico.Servico.domain.ServicoAExecutar;
import com.uzitec.clienteservico.Servico.domain.TipoPagamento;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServicoRequest {
	private ServicoAExecutar servicoExecutado;
	private BigDecimal valorServico;
	private TipoPagamento tipoPagamento;
}
