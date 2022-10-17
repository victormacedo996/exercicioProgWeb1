package com.example.gerenciadordecarros.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "carros")
public class Carro implements Serializable {

    private static final long serialVersionUID = 1848135320742265025L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelo;
    
    @ManyToMany
    @JoinTable(
        name = "carros_acessorio",
        joinColumns = { @JoinColumn(name = "acessorio_id") },
        inverseJoinColumns = { @JoinColumn(name = "carro_id") }
    )
    private List<Acessorio> acessorio;
    
    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;
    
    @OneToOne
    private Documento documento;
    
    @OneToOne
    private Chave chave;
    

    public List<Acessorio> getAcessorio() {
		return this.acessorio;
	}

	public void setAcessorio(List<Acessorio> acessorio) {
		this.acessorio = acessorio;
	}

	public Fabricante getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
}
