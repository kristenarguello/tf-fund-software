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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Pedido> pedidos;
    
    public Cliente(String nome) {
        this.nome = nome;
        this.pedidos = new HashSet<>();
    }

    protected Cliente(){}

    public long getId() { return this.id; }
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Pedido> getPedidos() { return Collections.unmodifiableSet(this.pedidos); }
    public boolean addPedido(Pedido p) { return this.pedidos.add(p); }
    public boolean removePedido(Pedido p) { return this.pedidos.remove(p); }
}
