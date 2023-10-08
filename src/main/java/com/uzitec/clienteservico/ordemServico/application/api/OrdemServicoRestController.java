package com.uzitec.clienteservico.ordemServico.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.request.PatchOrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;
import com.uzitec.clienteservico.ordemServico.application.service.OrdemServicoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoRestController implements OrdemServicoAPI {

	private final OrdemServicoService ordemServicoService;

	@Override
	public OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest) {
		log.info("[inicia] OrdemServicoRestController - saveOrdemServico");
		OrdemServicoResponse ordemServicoCriada = ordemServicoService.saveOrdemServico(ordemServicoRequest);
		log.info("[finaliza] OrdemServicoRestController - saveOrdemServico");
		return ordemServicoCriada;
	}

	@Override
	public OrdemServicoResponse findOrdemServicoById(Long idOrdemServico) {
		log.info("[inicia] OrdemServicoRestController - findOrdemServicoById");
		OrdemServicoResponse ordemServicoResponse = ordemServicoService.findOrdemServicoById(idOrdemServico);
		log.info("[finaliza] OrdemServicoRestController - findOrdemServicoById");
		return ordemServicoResponse;
	}

	@Override
	public List<OrdemServicoResponse> findAllOrdemServico() {
		log.info("[inicia] OrdemServicoRestController - findAllOrdemServico");
		List<OrdemServicoResponse> listOrdemServico = ordemServicoService.findAllOrdemServico();
		log.info("[finaliza] OrdemServicoRestController - findAllOrdemServico");
		return listOrdemServico;
	}

	@Override
	public void patchOrdemServico(Long idOrdemServico, @Valid PatchOrdemServicoRequest patchOrdemServicoRequest) {
		log.info("[inicia] OrdemServicoRestController - patchOrdemServico");
		ordemServicoService.patchOrdemServico(idOrdemServico,patchOrdemServicoRequest);
		log.info("[idOrdemServico] {}", idOrdemServico);
		log.info("[finaliza] OrdemServicoRestController - patchOrdemServico");
		
	}

}
