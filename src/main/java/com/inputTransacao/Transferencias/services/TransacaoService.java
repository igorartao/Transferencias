package com.inputTransacao.Transferencias.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.inputTransacao.Transferencias.model.AppProperties;
import com.inputTransacao.Transferencias.model.FavorecidoSuspeito;
import com.inputTransacao.Transferencias.model.Transacao;
import com.inputTransacao.Transferencias.repository.TransacaoRepository;

@Service
public class TransacaoService {
	@Autowired
	TransacaoRepository transacaoRepository;
	Transacao transacao;

	@Autowired
	AppProperties appProperties;

	public void saveTransacao(Transacao transacao) {
		String id = transacao.getNuCpfCnpjFavorecido();
		if (this.ehNuCpfCnpjSuspeito(id) == true) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_REQUIRED,
					"O Favorecido da transacao encontra-se na lista de favorecidos suspeitos da instituicao");
		}
		transacaoRepository.save(transacao);
	}

	public List<Transacao> listAllTransacoes() {
		return transacaoRepository.findAll();
	}

	public Boolean ehNuCpfCnpjSuspeito(String id) {

		String uri = appProperties.getUri().concat(id);
		RestTemplate restTemplate = new RestTemplate();

		try {
			FavorecidoSuspeito favorecidoSuspeito = restTemplate.getForObject(uri, FavorecidoSuspeito.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
