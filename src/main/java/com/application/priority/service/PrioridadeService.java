package com.application.priority.service;

import com.application.priority.model.Prioridade;

import java.time.LocalDate;
import java.util.List;

public interface PrioridadeService {

    Prioridade cadastrarPrioridade(Prioridade prioridade);

    List<Prioridade> listarTodasAsPrioridades();

    List<Prioridade> listarPrioridadesDeUmProfissional(Integer matricula);
}
