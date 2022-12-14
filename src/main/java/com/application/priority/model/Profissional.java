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
    @Column(length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional gerente;
    @Column(name="flag_gerente")
    private boolean flagGerente;

    @OneToMany
    @JoinColumn(name = "prioridade_id")
    private List<Prioridade> prioridades;

}
