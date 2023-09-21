package com.uzitec.clienteservico.orcamento.application.repository;

import java.util.List;

import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.orcamento.domain.Orcamento;

public interface OrcamentoRepository {
	Orcamento salvaOrcamento(Orcamento orcamento);
	List<Orcamento> getTodosOrcamentosDoCliente(Cliente cliente);
	Orcamento getOrcamentoPorId(Long idOrcamento);
}