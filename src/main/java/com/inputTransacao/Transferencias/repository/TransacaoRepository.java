package com.inputTransacao.Transferencias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inputTransacao.Transferencias.model.Transacao;

public interface TransacaoRepository extends MongoRepository<Transacao, String> {
	
}
