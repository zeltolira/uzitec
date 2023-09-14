package com.uzitec.clienteservico.funcionario.application.repository;

import java.util.List;
import java.util.UUID;

import com.uzitec.clienteservico.funcionario.domain.Funcionario;

public interface FuncionarioRepository {
	Funcionario salvaFuncionario(Funcionario funcionario);
	Funcionario buscaFuncionarioPorId(UUID idFuncionario);
	List<Funcionario> buscaTodosFuncionarios();
}