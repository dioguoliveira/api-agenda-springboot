package com.creathus.agenda.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.creathus.agenda.model.Contato;
import com.creathus.agenda.service.ContatoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;

@RestController
@RequestMapping(value = "/api/v1/contatos")
@Api(value = "API Contatos")
@CrossOrigin(origins = "*")
public class ContatoController {
	@Autowired
	public ContatoService contatoService;
	
	@GetMapping
	@ApiOperation(value = "Retorna listagem de todos os contatos.")
	public List<Contato> listarContatos() {
		return contatoService.listarContatos();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um contato único utilizando o código identificado como parâmetro.")
	public ResponseEntity<Contato> pesquisarContato(@PathVariable(value = "id") Long id) {
		 return contatoService.pesquisarContato(id)
				 .map(ResponseEntity::ok)
				 .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Cria um contato com os dados específicos.")
	public Contato criarContato(@Valid @RequestBody Contato contato) {
		return contatoService.criarContato(contato);
	}

	@DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Deleta um contato específico.")
	public void deletarContato(@RequestBody Contato contato) {
		contatoService.deletarContato(contato);
	}

	@PutMapping
	@ApiOperation(value = "Altera o contato de acordo com os dados enviados.")
	public Contato alterarContato(@RequestBody Contato contato) {
		return contatoService.alterarContato(contato);
	}
}
