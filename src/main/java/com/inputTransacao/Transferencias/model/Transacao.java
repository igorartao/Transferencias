package com.inputTransacao.Transferencias.model;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transacoes")
public class Transacao {

	@Id	
	private Integer codTransacao;
	
	private String nuCpfCnpjRemetente;

	private String nuCpfCnpjFavorecido;

	private BigDecimal vrTransacao;

	public Transacao() {

	}

	public Transacao(Integer codTransacao, String nuCpfCnpjRemetente, String nuCpfCnpjFavorecido,
			BigDecimal vrTransacao) {
		this.codTransacao = codTransacao;
		this.nuCpfCnpjRemetente = nuCpfCnpjRemetente;
		this.nuCpfCnpjFavorecido = nuCpfCnpjFavorecido;
		this.vrTransacao = vrTransacao;
	}
	
	public Integer getCodTransacao() {
		return codTransacao;
	}

	public String getNuCpfCnpjFavorecido() {
		return nuCpfCnpjFavorecido;
	}

	public String getNuCpfCnpjRemetente() {
		return nuCpfCnpjRemetente;
	}

	public BigDecimal getVrTransacao() {
		return vrTransacao;
	}

	public void setCodTransacao(Integer codTransacao) {
		this.codTransacao = codTransacao;
	}

	public void setNuCpfCnpjFavorecido(String nuCpfCnpjFavorecido) {
		this.nuCpfCnpjFavorecido = nuCpfCnpjFavorecido;
	}

	public void setNuCpfCnpjRemetente(String nuCpfCnpjRemetente) {
		this.nuCpfCnpjRemetente = nuCpfCnpjRemetente;
	}

	public void setVrTransacao(BigDecimal vrTransacao) {
		this.vrTransacao = vrTransacao;
	}

	@Override
	public String toString() {
		return "Transacao [codTransacao=" + codTransacao + ", nuCpfCnpjRemetente=" + nuCpfCnpjRemetente
				+ ", nuCpfCnpjFavorecido=" + nuCpfCnpjFavorecido + ", vrTransacao=" + vrTransacao + "]";
	}

}
