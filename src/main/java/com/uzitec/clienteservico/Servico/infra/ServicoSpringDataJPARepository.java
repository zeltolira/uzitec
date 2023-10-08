package com.uzitec.clienteservico.Servico.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uzitec.clienteservico.Servico.domain.Servico;

public interface ServicoSpringDataJPARepository extends JpaRepository<Servico, Long>{

}
