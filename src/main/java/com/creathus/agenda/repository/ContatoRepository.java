package com.creathus.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creathus.agenda.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
