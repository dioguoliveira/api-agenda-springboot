package com.creathus.agenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creathus.agenda.model.Contato;
import com.creathus.agenda.repository.ContatoRepository;

@RestController
@RequestMapping(value = "/api/v1/contatos")
public class ContatoController {
	@Autowired
	ContatoRepository contatoRepository;
	
	@GetMapping
	public List<Contato> listarContatos() {
		return contatoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Contato pesquisarContato(@PathVariable(value = "id") Long id) {
		Optional<Contato> optional = contatoRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@PostMapping
	public Contato criarContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}

	@DeleteMapping
	public void deletarContato(@RequestBody Contato contato) {
		contatoRepository.delete(contato);
	}

	@PutMapping
	public Contato alterarContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
}
