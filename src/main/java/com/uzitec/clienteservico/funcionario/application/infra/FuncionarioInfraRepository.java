package com.uzitec.clienteservico.funcionario.application.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.uzitec.clienteservico.funcionario.application.repository.FuncionarioRepository;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;
import com.uzitec.clienteservico.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class FuncionarioInfraRepository implements FuncionarioRepository {

	private final FuncionarioSpringDataJPARepository funcionarioSpringDataJPARepository;

	@Override
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		log.info("[inicia]FuncionarioInfraRepository salvaFuncionario");
		try {
			Funcionario funcionarioCriado = funcionarioSpringDataJPARepository.save(funcionario);
			log.info("[finaliza]FuncionarioInfraRepository salvaFuncionario");
			return funcionarioCriado;
		}catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Funcionário já cadastrado");
		}
	}

}
