package com.application.priority.service;

import com.application.priority.model.Profissional;
import com.application.priority.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalServiceImpl implements ProfissionalService{

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Override
    public Profissional salvar(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @Override
    public List<Profissional> listarProfissionais() {
        return (List<Profissional>) profissionalRepository.findAll();
    }

    @Override
    public Profissional atualizar(Profissional profissional, int matricula) {
        Profissional profissionalExistente = profissionalRepository.findById(matricula).get();
        profissionalExistente.setNome(profissionalExistente.getNome());
        return profissionalRepository.save(profissionalExistente);
    }

    @Override
    public void remover(int matricula) {
        profissionalRepository.deleteById(matricula);
    }
}
