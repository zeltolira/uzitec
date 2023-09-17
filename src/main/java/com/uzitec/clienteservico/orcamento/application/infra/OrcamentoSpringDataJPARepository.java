package com.uzitec.clienteservico.orcamento.application.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uzitec.clienteservico.orcamento.domain.Orcamento;

public interface OrcamentoSpringDataJPARepository extends JpaRepository<Orcamento, Long>{

}
