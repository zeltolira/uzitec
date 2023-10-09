package com.uzitec.clienteservico.Servico.application.api.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.uzitec.clienteservico.Servico.domain.Servico;
import com.uzitec.clienteservico.Servico.domain.ServicoAExecutar;
import com.uzitec.clienteservico.Servico.domain.TipoPagamento;

import lombok.Value;

@Value
public class ServicoResponse {
	private Long idServico;
	private ServicoAExecutar servicoExecutado;
	private BigDecimal valorServico;
	private TipoPagamento tipoPagamento;

	public ServicoResponse(Servico servico) {
		this.idServico = servico.getIdServico();
		this.servicoExecutado = servico.getServicoExecutado();
		this.valorServico = servico.getValorServico();
		this.tipoPagamento = servico.getTipoPagamento();
	}

	public static List<ServicoResponse> converte(List<Servico> servicos) {
		return servicos.stream()
				.map(ServicoResponse::new)
				.collect(Collectors.toList());
	}

}
