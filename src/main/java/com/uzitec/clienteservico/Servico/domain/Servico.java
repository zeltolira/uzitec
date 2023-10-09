package com.uzitec.clienteservico.Servico.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uzitec.clienteservico.Servico.application.api.request.ServicoRequest;
import com.uzitec.clienteservico.funcionario.domain.Funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private ServicoAExecutar servicoExecutado;
	private BigDecimal ValorServico;
	private TipoPagamento tipoPagamento;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	@JsonIgnore
	private Funcionario funcionario;

	public Servico(ServicoRequest servicoRequest) {
		this.servicoExecutado = servicoRequest.getServicoExecutado();
		this.ValorServico = servicoRequest.getValorServico();
	}

	public void patchServico(Servico servicoRequest) {
		this.servicoExecutado = servicoRequest.getServicoExecutado();
		this.ValorServico = servicoRequest.getValorServico();
	}


}
