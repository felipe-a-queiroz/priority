package com.application.priority.repository;

import com.application.priority.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrioridadeRepository extends JpaRepository<Prioridade, Integer> {

    List<Prioridade> findByProfissionalNome(String nome);

    List<Prioridade> findByProfissionalMatricula(Integer matricula);
}