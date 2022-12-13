package com.application.priority;

import com.application.priority.model.Meta;
import jakarta.persistence.EntityManager;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Log
public class Teste {

    @Autowired
    private static EntityManager em;

    public static void main(String[] args) {
        Meta meta = Meta.builder()
                .id(1)
                .nome("TesteMeta")
                .categoria(1)
                .dataLimite(new Date())
                .build();
        log.info("Persistindo: " + meta);
        em.persist(meta);
    }
}
