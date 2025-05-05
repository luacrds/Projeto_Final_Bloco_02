package com.example.projetofinalbloco02.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "tb_produtos")
public class Produto {


	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "O nome do produto é obrigatório.")
	    private String nome;

	    @NotBlank(message = "O código de barras é obrigatório.")
	    @Column(unique = true)
	    private String codigoBarras;

	    private String descricao;

	    @NotNull(message = "O preço é obrigatório.")
	    @DecimalMin(value = "0.0", inclusive = false)
	    private BigDecimal preco;

	    @Min(value = 0)
	    private int quantidadeEstoque;

	    private String fabricante;

	    private boolean precisaReceita;

	    private String principioAtivo;

	    private String dosagem;

	    private LocalDate dataValidade;

	    @ManyToOne
	    @JsonIgnoreProperties("produtos")
	    private Categoria categoria;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCodigoBarras() {
			return codigoBarras;
		}

		public void setCodigoBarras(String codigoBarras) {
			this.codigoBarras = codigoBarras;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public BigDecimal getPreco() {
			return preco;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public int getQuantidadeEstoque() {
			return quantidadeEstoque;
		}

		public void setQuantidadeEstoque(int quantidadeEstoque) {
			this.quantidadeEstoque = quantidadeEstoque;
		}

		public String getFabricante() {
			return fabricante;
		}

		public void setFabricante(String fabricante) {
			this.fabricante = fabricante;
		}

		public boolean isPrecisaReceita() {
			return precisaReceita;
		}

		public void setPrecisaReceita(boolean precisaReceita) {
			this.precisaReceita = precisaReceita;
		}

		public String getPrincipioAtivo() {
			return principioAtivo;
		}

		public void setPrincipioAtivo(String principioAtivo) {
			this.principioAtivo = principioAtivo;
		}

		public String getDosagem() {
			return dosagem;
		}

		public void setDosagem(String dosagem) {
			this.dosagem = dosagem;
		}

		public LocalDate getDataValidade() {
			return dataValidade;
		}

		public void setDataValidade(LocalDate dataValidade) {
			this.dataValidade = dataValidade;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
	    
	    
}


