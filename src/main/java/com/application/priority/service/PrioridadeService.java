package com.application.priority.service;

import com.application.priority.model.Prioridade;

import java.time.LocalDate;

public interface PrioridadeService {

    Prioridade cadastrarPrioridade(String nome, String descricao, LocalDate dataLimite, String nomeFuncionario);

    Prioridade cadastrarPrioridadeUtilizandoMatricula(String nome, String descricao, LocalDate dataLimite, Integer matricula);
}
