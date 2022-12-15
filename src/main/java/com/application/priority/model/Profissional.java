package com.application.priority.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profissional_id")
    private int matricula;
    @Column(length = 100)
    private String nome;

    @OneToMany
    @JoinColumn(name = "prioridade_id")
    private List<Prioridade> prioridades;

}
