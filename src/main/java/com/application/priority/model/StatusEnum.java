package com.application.priority.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor @ToString
public enum StatusEnum {
    TO_DO("TO DO"),
    IN_PROGRESS ("IN PROGRESS"),
    COMPLETED("COMPLETED"),
    ARCHIVED("ARCHIVED"),
    CANCELLED("CANCELLED");

    @Getter
    private String nome;
}
