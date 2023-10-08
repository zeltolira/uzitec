package com.uzitec.clienteservico.Servico.application.api.response;

import java.math.BigDecimal;

import com.uzitec.clienteservico.Servico.domain.Servico;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;

import lombok.Value;

@Value
public class ServicoResponse {
	private Long idServico;
	private ServicoAExecutar servicoExecutado;
	private BigDecimal ValorServico;

	public ServicoResponse(Servico servico) {
		this.idServico = servico.getIdServico();
		this.servicoExecutado = servico.getServicoExecutado();
		this.ValorServico = servico.getValorServico();
	}

}
