package com.application.priority.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profissional_id")
    private int matricula;
    private String nome;

    @ManyToOne
    private Profissional gerente;
    private boolean flagGerente;

    @OneToMany
    private List<Prioridade> prioridades;

}
