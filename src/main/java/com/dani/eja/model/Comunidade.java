package com.dani.eja.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "comunidades")
public class Comunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "localizacao")
    private String localizacao;

    @OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL)
    private Set<PesquisaResposta> respostas;

    // Getters e setters

        // Getter e Setter para id
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        // Getter e Setter para nome
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        // Getter e Setter para localizacao
        public String getLocalizacao() {
            return localizacao;
        }
    
        public void setLocalizacao(String localizacao) {
            this.localizacao = localizacao;
        }
}
