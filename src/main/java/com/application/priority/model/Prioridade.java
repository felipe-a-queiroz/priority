package com.application.priority.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="prioridades")
public class Prioridade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prioridade_id")
    private int id;
    @Column(length = 100)
    private String nome;
    @Column(length = 300)
    private String descricao;
    private LocalDate dataLimite;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

}
