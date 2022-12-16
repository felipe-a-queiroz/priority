package com.application.priority.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="prioridades")
public class Prioridade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prioridade_id")
    private Integer id;
    @Column(length = 100)
    private String nome;
    @Column(length = 300)
    private String descricao;
    private LocalDate dataLimite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id", foreignKey = @ForeignKey(name = "fk_profissional_id"))
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profissional profissional;

}
