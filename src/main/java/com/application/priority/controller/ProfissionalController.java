package com.application.priority.controller;

import com.application.priority.model.Profissional;
import com.application.priority.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/profissional")
public class ProfissionalController {

    @Autowired
    ProfissionalService profissionalService;

    @GetMapping
    public List<Profissional> listarProfissionais(){
        return profissionalService.listarProfissionais();
    }

    @PostMapping
    public Profissional cadastrarProfissional(@RequestBody Profissional profissional) {
        return profissionalService.salvar(profissional);
    }
}
