package com.dani.eja.model;

import com.dani.eja.enums.GrauEscolaridade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "respostas_pesquisa")
public class PesquisaResposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comunidade_id")
    private Comunidade comunidade;

    @Column(name = "participante", nullable = false)
    private String participante;

    @Column(name = "idade")
    private Integer idade;

    @Enumerated(EnumType.STRING)
    @Column(name = "grau_escolaridade", nullable = false)
    private GrauEscolaridade grauEscolaridade;

    @Column(name = "interesse_voltar_estudar", nullable = false)
    private Boolean interesseVoltarEstudar;

    // Getters e setters
    
    // Getter e Setter para id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e Setter para nome
    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    // Getter e Setter para idade
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Getter e Setter para comunidade
    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }

    // Getter e Setter para grauDeEscolaridade
    public GrauEscolaridade getGrauDeEscolaridade() {
        return grauEscolaridade;
    }

    public void setGrauDeEscolaridade(GrauEscolaridade grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    // Getter e Setter para interesseVoltarEstudar
    public boolean isInteresseVoltarEstudar() {
        return interesseVoltarEstudar;
    }

    public void setInteresseVoltarEstudar(boolean interesseVoltarEstudar) {
        this.interesseVoltarEstudar = interesseVoltarEstudar;
    }

}