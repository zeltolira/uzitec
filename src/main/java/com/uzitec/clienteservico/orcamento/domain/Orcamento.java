package com.uzitec.clienteservico.orcamento.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoPatchRequest;
import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orcamento")
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordem_servico")
	@SequenceGenerator(name = "ordem_servico", sequenceName = "ordem_servico")
	private Long idOrcamento;
	@NotNull
	private TipoProduto tipoProduto;
	@NotNull
	private Marca marca;
	@NotNull
	private ServicoAExecultar ServicoAExecultar;
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal valorOrcamento;
	private String observacao;
	@NotNull
	private LocalDate dataOrcamento;
	@NotNull
    @Min(0)
	private Integer garantia; // TODO: Implementar a lógica de validação aqui (valido por 10 dias corridos)
	
	private LocalDateTime dataAlteracaoOrcamento;
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	
	public Orcamento(Cliente cliente, OrcamentoRequest orcamentoRequest) {
		this.tipoProduto = orcamentoRequest.getTipoProduto();
		this.marca = orcamentoRequest.getMarca();
		ServicoAExecultar = orcamentoRequest.getServicoAExecultar();
		this.valorOrcamento = orcamentoRequest.getValorOrcamento();
		this.observacao = orcamentoRequest.getObservacao();
		this.dataOrcamento = orcamentoRequest.getDataOrcamento();
		this.garantia = orcamentoRequest.getGarantia();
		this.dataAlteracaoOrcamento = LocalDateTime.now();
	}

	public void patch(OrcamentoPatchRequest orcamentoRequest) {
		this.tipoProduto = orcamentoRequest.getTipoProduto();
		this.marca = orcamentoRequest.getMarca();
		this.ServicoAExecultar = orcamentoRequest.getServicoAExecultar();
		this.valorOrcamento = orcamentoRequest.getValorOrcamento();
		this.observacao = orcamentoRequest.getObservacao();
		this.dataOrcamento = orcamentoRequest.getDataOrcamento();
		this.garantia = orcamentoRequest.getGarantia();
		this.dataAlteracaoOrcamento = LocalDateTime.now();
		
	}
}