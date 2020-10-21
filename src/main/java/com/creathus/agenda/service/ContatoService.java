package com.creathus.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creathus.agenda.model.Contato;
import com.creathus.agenda.repository.ContatoRepository;

@Service
public class ContatoService {
	@Autowired
	ContatoRepository contatoRepository;

	public List<Contato> listarContatos() {
		return contatoRepository.findAll();
	}

	public Contato pesquisarContato(Long id) {
		Optional<Contato> optional = contatoRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Contato criarContato(Contato contato) {
		return contatoRepository.save(contato);
	}
	
	public void deletarContato(Contato contato) {
		contatoRepository.delete(contato);
	}
	
	public Contato alterarContato(Contato contato) {
		return contatoRepository.save(contato);
	}
}
