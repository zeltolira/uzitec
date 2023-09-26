package com.uzitec.clienteservico.orcamento.application.api.response;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrcamentoResponse {
	private Long idOrcamento;
	private UUID idCliente;
}
