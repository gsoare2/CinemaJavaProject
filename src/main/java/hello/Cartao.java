package hello;

import java.time.LocalDate;

public class Cartao {
	private String nomePessoaCartao;
	private String numeroCartao;
	private String numeroSeguranca;
	private String bandeiraCartao;
	private LocalDate dataVencimento;
	
	public Cartao(String nomePessoaCartao, String numeroCartao, String numeroSeguranca, String bandeiraCartao, LocalDate dataVencimento) {
		this.setNomePessoaCartao(nomePessoaCartao);
		this.setNumeroCartao(numeroCartao);
		this.setNumeroSeguranca(numeroSeguranca);
		this.setBandeiraCartao(bandeiraCartao);
		this.setDataVencimento(dataVencimento);
	}

	public String getNomePessoaCartao() {
		return nomePessoaCartao;
	}

	public void setNomePessoaCartao(String nomePessoaCartao) {
		this.nomePessoaCartao = nomePessoaCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNumeroSeguranca() {
		return numeroSeguranca;
	}

	public void setNumeroSeguranca(String numeroSeguranca) {
		this.numeroSeguranca = numeroSeguranca;
	}

	public String getBandeiraCartao() {
		return bandeiraCartao;
	}

	public void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
