package com.uzitec.clienteservico.orcamento.application.repository;

import com.uzitec.clienteservico.orcamento.domain.Orcamento;

public interface OrcamentoRepository {
	Orcamento salvaOrcamento(Orcamento orcamento);
}