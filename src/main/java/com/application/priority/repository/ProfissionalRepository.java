package com.application.priority.repository;

import com.application.priority.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
    List<Profissional> findByNome(String nome);
}
