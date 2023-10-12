package com.uzitec.clienteservico.Servico.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;
import com.uzitec.clienteservico.ordemServico.domain.OrdemServico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "servico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "servico", sequenceName = "servico")
	private Long idServico;
	@Enumerated(EnumType.STRING)
	private ServicoAExecutar servicoExecutado;
	private BigDecimal valorServico;
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	@JsonIgnore
	private Funcionario funcionario;
	
	@OneToOne
	@JoinColumn(name = "ordem_servico_id")
	private OrdemServico ordemServico;

	public Servico(ServicoRequest servicoRequest) {
		this.servicoExecutado = servicoRequest.getServicoExecutado();
		this.tipoPagamento = servicoRequest.getTipoPagamento();
		this.valorServico = servicoRequest.getValorServico();
	}

	public void patchServico(Servico servicoRequest) {
		this.servicoExecutado = servicoRequest.getServicoExecutado();
		this.valorServico = servicoRequest.getValorServico();
		this.tipoPagamento = servicoRequest.getTipoPagamento();

	}


}
