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
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 300, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private LocalDate dataLimite;

    @OneToOne
    @JoinColumn(name = "status_id", foreignKey = @ForeignKey(name = "fk_status_id"), nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profissional_id", foreignKey = @ForeignKey(name = "fk_profissional_id"), nullable = false)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profissional profissional;

}
