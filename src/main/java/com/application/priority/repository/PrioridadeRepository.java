package com.application.priority.repository;

import com.application.priority.model.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrioridadeRepository extends JpaRepository<Prioridade, Integer> {
}