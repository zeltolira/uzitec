package com.uzitec.clienteservico.ordemServico.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uzitec.clienteservico.Servico.domain.Servico;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;
import com.uzitec.clienteservico.orcamento.domain.Marca;
import com.uzitec.clienteservico.orcamento.domain.Orcamento;
import com.uzitec.clienteservico.orcamento.domain.ServicoAExecutar;
import com.uzitec.clienteservico.orcamento.domain.TipoProduto;
import com.uzitec.clienteservico.ordemServico.application.api.request.OrdemServicoRequest;
import com.uzitec.clienteservico.ordemServico.application.api.request.PatchOrdemServicoRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ordem_servico", sequenceName = "ordem_servico")
	private Long idOrdemServico;
	@Enumerated(EnumType.STRING)
	private TipoProduto tipoProduto;
	@Enumerated(EnumType.STRING)
	private Marca tipoMarca;
	@Enumerated(EnumType.STRING)
	private ServicoAExecutar servicoAExecutar;
	private String observacao;
	private LocalDate dataEntrega;

	@OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

	@OneToOne
	@JsonIgnore
	private Servico servico;

	public OrdemServico(Funcionario funcionario, Servico servico, Orcamento orcamento,  OrdemServicoRequest ordemServicoRequest) {
		this.tipoProduto = ordemServicoRequest.getTipoProduto();
		this.tipoMarca = ordemServicoRequest.getTipoMarca();
		this.servicoAExecutar = ordemServicoRequest.getServicoAExecutar();
		this.observacao = ordemServicoRequest.getObservacao();
		this.funcionario = funcionario;
		this.servico = servico;
	}

	public void patch(@Valid PatchOrdemServicoRequest patchOrdemServicoRequest) {
		this.tipoProduto = patchOrdemServicoRequest.getTipoProduto();
		this.tipoMarca = patchOrdemServicoRequest.getTipoMarca();
		this.servicoAExecutar = patchOrdemServicoRequest.getServicoAExecutar();
		this.observacao = patchOrdemServicoRequest.getObservacao();
	}

}