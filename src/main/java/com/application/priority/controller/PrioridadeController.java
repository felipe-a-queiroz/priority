package com.application.priority.controller;

import com.application.priority.model.Prioridade;
import com.application.priority.service.PrioridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/prioridade")
public class PrioridadeController {

    @Autowired
    private PrioridadeService prioridadeService;

    @GetMapping
    public List<Prioridade> listarTodasAsPrioridades(){
        return prioridadeService.listarTodasAsPrioridades();
    }

    @GetMapping("/{matricula}")
    public List<Prioridade> listarPrioridadesDeUmProfissional(@PathVariable Integer matricula){
        return prioridadeService.listarPrioridadesDeUmProfissional(matricula);
    }

    @PostMapping
    public Prioridade cadastrarPrioridade(@RequestBody Prioridade prioridade){
        return prioridadeService.cadastrarPrioridade(prioridade);
    }
}
