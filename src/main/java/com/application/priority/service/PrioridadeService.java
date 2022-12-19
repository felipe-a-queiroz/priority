package com.application.priority.service;

import com.application.priority.model.Prioridade;
import com.application.priority.model.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PrioridadeService {

    Prioridade cadastrarPrioridade(Prioridade prioridade);

    List<Prioridade> listarTodasAsPrioridades();

    List<Prioridade> listarPrioridadesDeUmProfissional(Integer matricula);

    Optional<Status> retrieveStatusByNome(String nome);

    Prioridade concluirPrioridade(Prioridade prioridade);

    Optional<Prioridade> findById(Integer prioridadeId);
}
