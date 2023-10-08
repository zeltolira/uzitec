package com.uzitec.clienteservico.Servico.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.Servico.application.api.response.ServicoResponse;
import com.uzitec.clienteservico.Servico.application.repostory.ServicoRepository;
import com.uzitec.clienteservico.Servico.domain.Servico;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ServicoApplicationService implements ServicoService {

	private final ServicoRepository servicoRepository;

	@Override
	public ServicoResponse postServico(ServicoRequest servicoRequest) {
		log.info("[inicia]ServicoApplicationService - postServico");
		Servico servico = servicoRepository.saveServico(new Servico(servicoRequest));
		log.info("[finaliza]ServicoApplicationService - postServico");
		return new ServicoResponse(servico);
	}

	@Override
	public ServicoResponse findServicoById(Long idServico) {
		log.info("[inicia]ServicoApplicationService - findServicoById");
		Servico servico = servicoRepository.findServicoById(idServico);
		log.info("[finaliza]ServicoApplicationService - findServicoById");
		return new ServicoResponse(servico);
	}

	@Override
	public List<ServicoResponse> findAllServico() {
		log.info("[inicia]ServicoApplicationService - findAllServico");
		List<Servico> servicos = servicoRepository.findAllServico();
		log.info("[finaliza]ServicoApplicationService - findAllServico");
		return ServicoResponse.converte(servicos);
	}

	@Override
	public void deleteServico(Long idServico) {
		log.info("[inicia]ServicoApplicationService - deleteServico");
		Servico servico = servicoRepository.findServicoById(idServico);
		servicoRepository.deleteServico(servico.getIdServico());
		log.info("[finaliza]ServicoApplicationService - deleteServico");
	}

	@Override
	public void patchServico(Long idServico, ServicoRequest servicoRequest) {
		log.info("[inicia]ServicoApplicationService - patchServico");
		Servico servico = servicoRepository.findServicoById(idServico);
		servico.patchServico(servico);
		servicoRepository.saveServico(servico);
		log.info("[finaliza]ServicoApplicationService - patchServico");
	}
}