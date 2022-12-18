package com.application.priority.controller;

import com.application.priority.model.Prioridade;
import com.application.priority.service.PrioridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
