package com.uzitec.clienteservico.ordemServico.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

public interface OrdemServicoSpringJPARepository extends JpaRepository<OrdemServico, Long>{

}
