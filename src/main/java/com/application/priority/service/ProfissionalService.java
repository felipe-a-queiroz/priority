package com.application.priority.service;

import com.application.priority.model.Profissional;

import java.util.List;
import java.util.Optional;

public interface ProfissionalService {

    Profissional salvar(Profissional profissional);

    List<Profissional> listarProfissionais();

    Profissional buscarPorNome(String nome);

    Optional<Profissional> buscarPorId(Integer matricula);

    Profissional atualizar(String nome, Integer matricula);

    void remover(int matricula);

}
