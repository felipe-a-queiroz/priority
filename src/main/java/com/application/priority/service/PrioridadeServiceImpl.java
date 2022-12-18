package com.application.priority.service;

import com.application.priority.model.Prioridade;
import com.application.priority.model.Profissional;
import com.application.priority.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrioridadeServiceImpl implements PrioridadeService {

    @Autowired
    private PrioridadeRepository prioridadeRepository;

    @Autowired
    private ProfissionalService profissionalService;

    @Override
    public List<Prioridade> listarTodasAsPrioridades(){
        return prioridadeRepository.findAll();
    }

    @Override
    public List<Prioridade> listarPrioridadesDeUmProfissional(Integer matricula) {
        return prioridadeRepository.findByProfissionalMatricula(matricula);
    }

    @Override
    public Prioridade cadastrarPrioridade(String nome, String descricao, LocalDate dataLimite, String nomeFuncionario) {
        Prioridade prioridade = Prioridade.builder()
                .nome(nome)
                .descricao(descricao)
                .dataLimite(dataLimite)
                .build();

        Profissional profissional = profissionalService.buscarPorNome(nomeFuncionario);
        prioridade.setProfissional(profissional);

        return prioridadeRepository.save(prioridade);
    }

    @Override
    public Prioridade cadastrarPrioridadeUtilizandoMatricula(String nome, String descricao, LocalDate dataLimite, Integer matricula) {
        Prioridade prioridade = Prioridade.builder()
                .nome(nome)
                .descricao(descricao)
                .dataLimite(dataLimite)
                .build();

        Optional<Profissional> profissional = profissionalService.buscarPorId(matricula);

        if(profissional.isPresent()){
            prioridade.setProfissional(profissional.get());
        }

        return prioridadeRepository.save(prioridade);
    }
}
