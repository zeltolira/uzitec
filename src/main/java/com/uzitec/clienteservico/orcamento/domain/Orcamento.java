package com.uzitec.clienteservico.orcamento.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordem_servico")
	@SequenceGenerator(name = "ordem_servico", sequenceName = "ordem_servico")
	private Long idOrcamento;
	private TipoProduto tipoProduto;
	private Marca marca;
	private ServicoAExecultar ServicoAExecultar;
	private BigDecimal valorOrcamento;
	private LocalDate dataOrcamento;
	private Integer garantia;
	
	private LocalDateTime dataAlteracaoOrcamento;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Orcamento(Cliente cliente, OrcamentoRequest orcamentoRequest) {
		this.tipoProduto = orcamentoRequest.getTipoProduto();
		this.marca = orcamentoRequest.getMarca();
		ServicoAExecultar = orcamentoRequest.getServicoAExecultar();
		this.valorOrcamento = orcamentoRequest.getValorOrcamento();
		this.dataOrcamento = orcamentoRequest.getDataOrcamento();
		this.garantia = orcamentoRequest.getGarantia();
		this.dataAlteracaoOrcamento = LocalDateTime.now();
	}
}