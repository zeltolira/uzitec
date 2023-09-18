package com.uzitec.clienteservico.orcamento.application.api.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.uzitec.clienteservico.orcamento.domain.Orcamento;

import lombok.Value;

@Value
public class OrcamentoListResponse {
	private Long idOrcamento;
	private BigDecimal valorOrcamento;
	private LocalDate dataOrcamento;
	private Integer garantia;
	
	
	public static List<OrcamentoListResponse> converte(List<Orcamento> orcamento) {
		return orcamento.stream()
				.map(OrcamentoListResponse::new)
				.collect(Collectors.toList());
	}


	public OrcamentoListResponse(Orcamento orcamento) {
		this.idOrcamento = orcamento.getIdOrcamento();
		this.valorOrcamento = orcamento.getValorOrcamento();
		this.dataOrcamento = orcamento.getDataOrcamento();
		this.garantia = orcamento.getGarantia();
	}
	
	
}
