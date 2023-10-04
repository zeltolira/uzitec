package com.uzitec.clienteservico.ordemServico.infra;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.uzitec.clienteservico.handler.APIException;
import com.uzitec.clienteservico.ordemServico.application.repository.OrdemServicoRepository;
import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoInfraRepository implements OrdemServicoRepository {

	private final OrdemServicoSpringJPARepository ordemServicoSpringJPARepository;

	@Override
	public OrdemServico saveOrdemServico(OrdemServico ordemServico) {
		log.info("[inicia] OrdemServicoInfraRepository - postOrdemServico");
		OrdemServico ordemServicoCriado = ordemServicoSpringJPARepository.save(ordemServico);
		log.info("[finaliza] OrdemServicoInfraRepository - postOrdemServico");
		return ordemServicoCriado;
	}

	@Override
	public OrdemServico findByOrdemServicoById(Long idOrdemServico) {
		log.info("[inicia] OrdemServicoInfraRepository - findByOrdemServicoById");
		Optional<OrdemServico> optionalOrdemServico = ordemServicoSpringJPARepository.findById(idOrdemServico);
		OrdemServico ordemServico = optionalOrdemServico.orElseThrow(()-> APIException.build(HttpStatus.BAD_REQUEST, "Ordem de servico não encontrada!"));
		log.info("[finaliza] OrdemServicoInfraRepository - findByOrdemServicoById");
		return ordemServico;
	}

}
