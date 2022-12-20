package com.application.priority.model;

import java.time.LocalDate;

public record PrioridadeAtualizarRecord(Integer id, String nome, String descricao, LocalDate dataLimite, StatusEnum status, Integer matricula) {
}
