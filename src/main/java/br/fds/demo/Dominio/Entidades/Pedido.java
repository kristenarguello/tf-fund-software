package br.fds.demo.Dominio.Entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Collections;
import java.util.LinkedList;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @OneToMany
    @JoinColumn(name = "codigo")
    private List<ItemPedido> itensPedido;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Cliente cliente;

    @OneToOne
    private Orcamento orcamento;

    public Pedido(Cliente cliente) throws IllegalArgumentException {
        this.itensPedido = new LinkedList<>();
    }

    protected Pedido() {}
    public long getCodigo() { return codigo; }
    public List<ItemPedido> getItens() { return Collections.unmodifiableList(itensPedido); }
    public boolean removeItem(ItemPedido item) { return itensPedido.remove(item); }
    public boolean addItem(ItemPedido item) { return itensPedido.add(item); }
    public Cliente getCliente() { return cliente; }
    public void setOrcamento(Orcamento orcamento) { this.orcamento = orcamento; }
    public Orcamento getOrcamento() { return orcamento; }
}