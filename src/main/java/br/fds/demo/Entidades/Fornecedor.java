package br.fds.demo.Entidades;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    public Fornecedor(long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtos = new HashSet<>();
    }

    protected Fornecedor(){}
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "fornecedor_id")
    @JsonManagedReference
    private Set<Produto> produtos;
    
    public Set<Produto> getProdutos() {
        return produtos;
    }
    
    public void getProdutos(Set<Produto> prods) {
        this.produtos = prods;
    }
    
    public long getCodigo() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return "Produto [codigo=" + id + ", nome=" + nome + "]";
    }
}
