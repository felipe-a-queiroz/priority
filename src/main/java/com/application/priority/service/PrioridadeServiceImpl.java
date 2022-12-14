package com.application.priority.service;

import com.application.priority.model.Prioridade;
import com.application.priority.model.Profissional;
import com.application.priority.model.Status;
import com.application.priority.model.StatusEnum;
import com.application.priority.repository.PrioridadeRepository;
import com.application.priority.repository.StatusRepository;
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

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Prioridade> listarTodasAsPrioridades(){
        return prioridadeRepository.findAll();
    }

    @Override
    public List<Prioridade> listarPrioridadesDeUmProfissional(Integer matricula) {
        return prioridadeRepository.findByProfissionalMatricula(matricula);
    }

    @Override
    public Optional<Status> retrieveStatusByNome(String nome) {
        return statusRepository.findByNome(nome);
    }

    @Override
    public Prioridade concluirPrioridade(Prioridade prioridade) {
        Optional<Status> status = retrieveStatusByNome(StatusEnum.COMPLETED.getNome());
        prioridade.setStatus(status.get());
        return prioridadeRepository.save(prioridade);
    }

    @Override
    public Optional<Prioridade> findById(Integer prioridadeId) {
        return prioridadeRepository.findById(prioridadeId);
    }

    @Override
    public Prioridade atualizar(Prioridade prioridade) {
        return prioridadeRepository.save(prioridade);
    }

    @Override
    public void remover(Prioridade prioridade) {
        prioridadeRepository.delete(prioridade);
    }

    @Override
    public Prioridade cadastrarPrioridade(Prioridade prioridade) {
        if(prioridade.getProfissional().getNome() == null){
            Optional<Profissional> profissional = profissionalService.buscarPorId(prioridade.getProfissional().getMatricula());
            if(profissional.isPresent()){
                prioridade.setProfissional(profissional.get());
            }
        }
        return prioridadeRepository.save(prioridade);
    }

}
