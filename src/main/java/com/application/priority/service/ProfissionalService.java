package com.application.priority.service;

import com.application.priority.model.Profissional;

import java.util.List;

public interface ProfissionalService {

    Profissional salvar(Profissional profissional);

    List<Profissional> listarProfissionais();

    Profissional atualizar(Profissional profissional, int matricula);

    void remover(int matricula);

}
