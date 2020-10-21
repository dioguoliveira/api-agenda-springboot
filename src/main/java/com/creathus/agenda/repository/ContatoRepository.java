package com.creathus.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creathus.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
