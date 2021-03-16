package com.inputTransacao.Transferencias.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "favorecidos.suspeitos")
public class AppProperties {
	private String uri;

	public AppProperties() {
		if (uri == null) System.out.println("Nao foi possivel ler as informacoes da uri");
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
