package com.uzitec.clienteservico.Servico.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.uzitec.clienteservico.Servico.application.repostory.ServicoRepository;
import com.uzitec.clienteservico.Servico.domain.Servico;
import com.uzitec.clienteservico.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ServicoInfraRepository implements ServicoRepository {

	private final  ServicoSpringDataJPARepository servicoSpringDataJPARepository;

	@Override
	public Servico saveServico(Servico servico) {
		log.info("[inicia] ServicoInfraRepository - postServico");
		try{
			servicoSpringDataJPARepository.save(servico);
		}catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Serviço já cadastrado");
		}
		log.info("[finaliza] ServicoInfraRepository - postServico");
		return servico;
	}

	@Override
	public Servico findServicoById(Long idServico) {
		log.info("[inicia] ServicoInfraRepository - findServicoById");
		Optional<Servico> optionalServico = servicoSpringDataJPARepository.findById(idServico);
		Servico servico = optionalServico.orElseThrow(()-> APIException.build(HttpStatus.BAD_REQUEST, "Serviço não encontrado!" ));
		log.info("[finaliza] ServicoInfraRepository - findServicoById");
		return servico;
	}

	@Override
	public List<Servico> findAllServico() {
		log.info("[inicia] ServicoInfraRepository - findAllServico");
		List<Servico> allServicos = servicoSpringDataJPARepository.findAll();
		log.info("[finaliza] ServicoInfraRepository - findAllServico");
		return allServicos;
	}

	@Override
	public void deleteServico(Long idServico) {
		log.info("[inicia] ServicoInfraRepository - deleteServico");
		servicoSpringDataJPARepository.deleteById(idServico);
		log.info("[finaliza] ServicoInfraRepository - deleteServico");		
	}

}
