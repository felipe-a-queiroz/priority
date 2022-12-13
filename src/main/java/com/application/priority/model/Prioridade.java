package com.application.priority.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="prioridades")
public class Prioridade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="prioridade_id")
    private int id;
    private String nome;
    private String descricao;
    private Date dataLimite;

    @OneToMany
    private List<Meta> metasAtendidas;
}
