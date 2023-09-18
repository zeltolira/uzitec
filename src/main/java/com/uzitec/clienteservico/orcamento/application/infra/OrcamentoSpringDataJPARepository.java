package com.uzitec.clienteservico.orcamento.application.infra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.orcamento.domain.Orcamento;

public interface OrcamentoSpringDataJPARepository extends JpaRepository<Orcamento, Long>{
	List<Orcamento> findByCliente(Cliente cliente);
}
