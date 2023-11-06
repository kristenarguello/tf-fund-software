package br.fds.demo.Dominio.Entidades;

import java.util.Collections;
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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;    
    
    public Cliente(long codigo, String nome, int qtdCompras) {
        this.id = codigo;
        this.nome = nome;
        this.pedidos = new HashSet<>();
    }

    protected Cliente(){}
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    @JsonManagedReference
    private Set<Pedido> pedidos; 

    public Set<Pedido> getPedidos() {
        return Collections.unmodifiableSet(pedidos);
    }

    public void setcodigo(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
