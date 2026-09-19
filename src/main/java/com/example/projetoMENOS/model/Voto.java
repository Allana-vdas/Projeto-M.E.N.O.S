package com.example.projetoMENOS.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Votos")

public class Voto implements Serializable {
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private  Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "opcao_id")
    private  OpcaoVoto opcaoEscolhida;
    private LocalDateTime dataVoto;

    public Voto() {

    }

    public Voto(Long id, Estudante estudante, OpcaoVoto opcaoEscolhida, LocalDateTime dataVoto) {
        this.id = id;
        this.estudante = estudante;
        this.opcaoEscolhida = opcaoEscolhida;
        this.dataVoto = dataVoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public OpcaoVoto getOpcaoEscolhida() {
        return opcaoEscolhida;
    }

    public void setOpcaoEscolhida(OpcaoVoto opcaoEscolhida) {
        this.opcaoEscolhida = opcaoEscolhida;
    }

    public LocalDateTime getDataVoto() {
        return dataVoto;
    }

    public void setDataVoto(LocalDateTime dataVoto) {
        this.dataVoto = dataVoto;
    }
}
