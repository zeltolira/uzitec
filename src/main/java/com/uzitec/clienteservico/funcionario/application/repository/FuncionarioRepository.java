package com.uzitec.clienteservico.funcionario.application.repository;

import com.uzitec.clienteservico.funcionario.domain.Funcionario;

public interface FuncionarioRepository {
	Funcionario salvaFuncionario(Funcionario funcionario);
}