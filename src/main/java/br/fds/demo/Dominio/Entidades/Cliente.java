package br.fds.demo.Dominio.Entidades;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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
    private long codigo;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "codigo")
    private Set<Pedido> pedidos; 
    
    public Cliente(String nome) {
        this.nome = nome;
        this.pedidos = new HashSet<>();
    }

    protected Cliente(){}

    public long getCodigo() { return this.codigo; }
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Pedido> getPedidos() { return Collections.unmodifiableSet(this.pedidos); }
    public boolean addPedido(Pedido p) { return this.pedidos.add(p); }
    public boolean removePedido(Pedido p) { return this.pedidos.remove(p); }
}
