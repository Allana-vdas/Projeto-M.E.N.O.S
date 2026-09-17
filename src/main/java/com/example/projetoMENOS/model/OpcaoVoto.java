package com.example.projetoMENOS.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "OpcoesVoto")

public class OpcaoVoto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String descricao;

    public OpcaoVoto() {

    }

    public OpcaoVoto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

