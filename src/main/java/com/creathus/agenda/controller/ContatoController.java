package com.creathus.agenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/contatos")
@Api(value = "API Contatos")
@CrossOrigin(origins = "*")
public class ContatoController {
	@Autowired
	ContatoRepository contatoRepository;
	
	@GetMapping
	@ApiOperation(value = "Retorna listagem de todos os contatos.")
	public List<Contato> listarContatos() {
		return contatoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um contato único utilizando o código identificado como parâmetro.")
	public Contato pesquisarContato(@PathVariable(value = "id") Long id) {
		Optional<Contato> optional = contatoRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@PostMapping
	@ApiOperation(value = "Cria um contato com os dados específicos.")
	public Contato criarContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}

	@DeleteMapping
	@ApiOperation(value = "Deleta um contato específico.")
	public void deletarContato(@RequestBody Contato contato) {
		contatoRepository.delete(contato);
	}

	@PutMapping
	@ApiOperation(value = "Altera o contato de acordo com os dados enviados.")
	public Contato alterarContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
}
