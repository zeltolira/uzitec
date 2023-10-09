package com.uzitec.clienteservico.ordemServico.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uzitec.clienteservico.funcionario.application.repository.FuncionarioRepository;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;
import com.uzitec.clienteservico.orcamento.application.repository.OrcamentoRepository;
import com.uzitec.clienteservico.orcamento.domain.Orcamento;
import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.request.PatchOrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.response.OrdemServicoResponse;
import com.uzitec.clienteservico.ordemServico.application.repository.OrdemServicoRepository;
import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoApplicationService implements OrdemServicoService {

	private final OrdemServicoRepository ordemServicoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final OrcamentoRepository orcamentoRepository;

	@Override
	public OrdemServicoResponse saveOrdemServico(OrdemServicoRequest ordemServicoRequest) {
		log.info("[inicia] OrdemServiceApplicationService - postOrdemServico");
		Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(ordemServicoRequest.getIdFuncionario());
		Orcamento orcamento = orcamentoRepository.getOrcamentoPorId(ordemServicoRequest.getIdOrcamento());
		OrdemServico ordemServico = ordemServicoRepository.saveOrdemServico(new OrdemServico(funcionario, orcamento, ordemServicoRequest));
		orcamentoRepository.deleteOrcamento(ordemServicoRequest.getIdOrcamento());
		log.info("[finaliza] OrdemServiceApplicationService - postOrdemServico");
		return new OrdemServicoResponse(ordemServico);
	}

	@Override
	public OrdemServicoResponse findOrdemServicoById(Long idOrdemServico) {
		log.info("[inicia] OrdemServiceApplicationService - findOrdemServicoById");
		OrdemServico ordemServico = ordemServicoRepository.findByOrdemServicoById(idOrdemServico);
		log.info("[finaliza] OrdemServiceApplicationService - findOrdemServicoById");
		return new OrdemServicoResponse(ordemServico);
	}

	@Override
	public List<OrdemServicoResponse> findAllOrdemServico() {
		log.info("[inicia] OrdemServiceApplicationService - findAllOrdemServico");
		List<OrdemServico> ordemServicos = ordemServicoRepository.findAllOrdemServico();
		log.info("[finaliza] OrdemServiceApplicationService - findAllOrdemServico");
		return OrdemServicoResponse.converte(ordemServicos);
	}

	@Override
	public void patchOrdemServico(Long idOrdemServico, @Valid PatchOrdemServicoRequest patchOrdemServicoRequest) {
		log.info("[inicia] OrdemServiceApplicationService - patchOrdemServico");
		OrdemServico ordemServico = ordemServicoRepository.findByOrdemServicoById(idOrdemServico);
		ordemServico.patch(patchOrdemServicoRequest);
		ordemServicoRepository.saveOrdemServico(ordemServico);
		log.info("[finaliza] OrdemServiceApplicationService - patchOrdemServico");	
	}

	

}
