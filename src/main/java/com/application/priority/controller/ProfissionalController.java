package com.application.priority.controller;

import com.application.priority.model.Profissional;
import com.application.priority.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/profissional")
public class ProfissionalController {

    private final String PROFISSIONAL_NAO_EXISTENTE = "Profissional não existente";
    private final String PARAMETRO_NAO_INFORMADO = "Parâmetro obrigatório não informado";

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

    @PutMapping
    public Profissional atualizarProfissional(@RequestBody Profissional profissional){
        Optional<Profissional> profissionalExistente = profissionalService.buscarPorId(profissional.getMatricula());
        if(profissionalExistente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, PROFISSIONAL_NAO_EXISTENTE);
        }
        return profissionalService.atualizar(profissional);
    }

    @DeleteMapping(value = "/{matricula}")
    public ResponseEntity deletarProfissional(@PathVariable Integer matricula){
        Optional<Profissional> profissional = profissionalService.buscarPorId(matricula);
        if(profissional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, PROFISSIONAL_NAO_EXISTENTE);
        }
        profissionalService.remover(matricula);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public void deletarProfissionalSemPassarParametroNemBarra(){
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, PARAMETRO_NAO_INFORMADO);
    }

    @DeleteMapping(value = "/")
    public void deletarProfissionalSemPassarParametro(){
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, PARAMETRO_NAO_INFORMADO);
    }
}
