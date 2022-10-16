package com.example.gerenciadordecarros.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "acessorios")
public class Acessorio implements Serializable {

    private static final long serialVersionUID = -4289840979416081400L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    
    @ManyToMany
    @JoinTable(
        name = "acessorio_carro",
        joinColumns = { @JoinColumn(name = "acessorio_id") },
        inverseJoinColumns = { @JoinColumn(name = "carro_id") }
    )
    private List<Carro> acessorios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
