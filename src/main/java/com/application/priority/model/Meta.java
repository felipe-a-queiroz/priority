package com.application.priority.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "metas")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="meta_id")
    private int id;
    private int categoria;
    private String nome;
    private String descricao;
    private Date dataLimite;
}
