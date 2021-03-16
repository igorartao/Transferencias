package com.inputTransacao.Transferencias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inputTransacao.Transferencias.model.Transacao;
import com.inputTransacao.Transferencias.services.TransacaoService;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

	@Autowired
	TransacaoService transacaoService;

	@PostMapping("/")
	public void add(@RequestBody Transacao transacao) {
		transacaoService.saveTransacao(transacao);
	}

	@GetMapping("")
	public List<Transacao> list() {
		return transacaoService.listAllTransacoes();
	}

}
