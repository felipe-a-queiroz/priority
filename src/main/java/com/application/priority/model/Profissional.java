package com.application.priority.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profissional_id")
    private Integer matricula;
    @Column(length = 100, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "profissional")
    @JsonIgnore
    private List<Prioridade> prioridades;

}
