package com.uzitec.clienteservico.orcamento.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.uzitec.clienteservico.cliente.domain.Cliente;
import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoPatchRequest;
import com.uzitec.clienteservico.orcamento.application.api.request.OrcamentoRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "orcamento")
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "orcamento", sequenceName = "orcamento")
	private Long idOrcamento;
	@NotNull
	private TipoProduto tipoProduto;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Marca marca;
	@Column (name = "servicoAExecultar")
	@Enumerated(EnumType.STRING)
	private ServicoAExecutar servicoAExecultar;
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal valorOrcamento;
	private String observacao;
	@NotNull
	private LocalDate dataOrcamento;
	@NotNull
    @Min(0)
	private Integer garantia; // TODO: Implementar a lógica de validação aqui (valido por 10 dias corridos)
	
	private LocalDateTime dataHoraCadastroOrcamento;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;
	

	public Orcamento(Cliente cliente, OrcamentoRequest orcamentoRequest) {
		this.tipoProduto = orcamentoRequest.getTipoProduto();
		this.marca = orcamentoRequest.getMarca();
		this.servicoAExecultar = orcamentoRequest.getServicoAExecultar();
		this.valorOrcamento = orcamentoRequest.getValorOrcamento();
		this.observacao = orcamentoRequest.getObservacao();
		this.dataOrcamento = orcamentoRequest.getDataOrcamento();
		this.garantia = orcamentoRequest.getGarantia();
		this.dataHoraCadastroOrcamento = LocalDateTime.now();
		this.cliente = cliente;
	}

	public void patch(OrcamentoPatchRequest orcamentoRequest) {
		this.tipoProduto = orcamentoRequest.getTipoProduto();
		this.marca = orcamentoRequest.getMarca();
		this.servicoAExecultar = orcamentoRequest.getServicoAExecultar();
		this.valorOrcamento = orcamentoRequest.getValorOrcamento();
		this.observacao = orcamentoRequest.getObservacao();
		this.dataOrcamento = orcamentoRequest.getDataOrcamento();
		this.garantia = orcamentoRequest.getGarantia();
		this.dataHoraCadastroOrcamento = LocalDateTime.now();
		
	}
}