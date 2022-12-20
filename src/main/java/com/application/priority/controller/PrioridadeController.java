package com.application.priority.controller;

import com.application.priority.model.*;
import com.application.priority.service.PrioridadeService;
import com.application.priority.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/prioridade")
public class PrioridadeController {

    @Autowired
    private PrioridadeService prioridadeService;

    @Autowired
    private ProfissionalService profissionalService;

    private final String PROFISSIONAL_NAO_EXISTENTE = "Profissional não existente";
    private final String PRIORIDADE_NAO_EXISTENTE = "Prioridade não existente";
    private final String STATUS_NAO_EXISTENTE = "Status não existente";

    @GetMapping
    public List<Prioridade> listarTodasAsPrioridades(){
        return prioridadeService.listarTodasAsPrioridades();
    }

    @GetMapping("/{matricula}")
    public List<Prioridade> listarPrioridadesDeUmProfissional(@PathVariable Integer matricula){
        return prioridadeService.listarPrioridadesDeUmProfissional(matricula);
    }

    @PutMapping("/{prioridadeId}")
    public Prioridade concluirPrioridade(@PathVariable Integer prioridadeId){
        Optional<Prioridade> prioridade = prioridadeService.findById(prioridadeId);
        if(prioridade.isPresent()){
            return prioridadeService.concluirPrioridade(prioridade.get());
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null);
        }
    }

    @PostMapping
    public Prioridade cadastrarPrioridade(@RequestBody PrioridadeRecord prioridadeRecord){
        Prioridade prioridade = Prioridade.builder()
                .nome(prioridadeRecord.nome())
                .descricao(prioridadeRecord.descricao())
                .dataLimite(prioridadeRecord.dataLimite())
                .build();

        Optional<Status> status = prioridadeService.retrieveStatusByNome(prioridadeRecord.status().getNome());
        if(status.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, STATUS_NAO_EXISTENTE);
        }
        prioridade.setStatus(status.get());
        Optional<Profissional> profissional = profissionalService.buscarPorId(prioridadeRecord.matricula());
        if(profissional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, PROFISSIONAL_NAO_EXISTENTE);
        }
        prioridade.setProfissional(profissional.get());

        return prioridadeService.cadastrarPrioridade(prioridade);
    }

    @PutMapping
    public Prioridade atualizar(@RequestBody PrioridadeAtualizarRecord prioridadeAtualizarRecord){
        Optional<Prioridade> prioridadeExistente = prioridadeService.findById(prioridadeAtualizarRecord.id());
        if(prioridadeExistente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, PRIORIDADE_NAO_EXISTENTE);
        }

        Prioridade prioridade = prioridadeExistente.get();

        Optional<Status> status = prioridadeService.retrieveStatusByNome(prioridadeAtualizarRecord.status().getNome());
        if(status.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, STATUS_NAO_EXISTENTE);
        }
        prioridade.setStatus(status.get());
        Optional<Profissional> profissional = profissionalService.buscarPorId(prioridadeAtualizarRecord.matricula());
        if(profissional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, PROFISSIONAL_NAO_EXISTENTE);
        }
        prioridade.setProfissional(profissional.get());

        prioridade.setNome(prioridadeAtualizarRecord.nome());
        prioridade.setDescricao(prioridadeAtualizarRecord.descricao());
        prioridade.setDataLimite(prioridadeAtualizarRecord.dataLimite());

        return prioridadeService.cadastrarPrioridade(prioridade);
    }
}
