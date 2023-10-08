package com.uzitec.clienteservico.Servico.application.repostory;

import java.util.List;

import com.uzitec.clienteservico.Servico.domain.Servico;

public interface ServicoRepository {
	Servico postServico(Servico servico);
	Servico findServicoById(Long idServico);
	List<Servico> findAllServico();
	void deleteServico(Long idServico);
	void saveServico(Servico servico);
}
