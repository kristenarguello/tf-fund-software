package br.fds.demo.Dominio.Entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.LinkedList;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ItemPedido> itensPedido;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Orcamento> orcamentos;

    public Pedido(Cliente cliente) throws IllegalArgumentException {
        this.itensPedido = new LinkedList<>();
        this.orcamentos = new LinkedList<>();
        this.cliente = cliente;
    }

    protected Pedido() {
    }

    public long getId() {
        return id;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itensPedido);
    }

    public boolean removeItem(ItemPedido item) {
        return itensPedido.remove(item);
    }

    public boolean addItem(ItemPedido item) {
        return itensPedido.add(item);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void addOrcamento(Orcamento orcamento) {
        orcamentos.add(orcamento);
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }
}