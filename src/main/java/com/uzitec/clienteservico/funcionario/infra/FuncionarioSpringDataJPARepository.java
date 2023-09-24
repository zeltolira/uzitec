package com.uzitec.clienteservico.funcionario.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uzitec.clienteservico.funcionario.domain.Funcionario;

public interface FuncionarioSpringDataJPARepository extends JpaRepository<Funcionario, UUID>{

}
