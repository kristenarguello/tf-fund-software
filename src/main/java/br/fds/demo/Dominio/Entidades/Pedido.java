package br.fds.demo.Dominio.Entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name="nome_cliente")
    private String nomeCliente;

    @OneToMany
    @JoinColumn(name = "codigo")
    private List<ItemPedido> itensPedido;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Cliente cliente;

    @OneToOne
    private Orcamento orcamento;

    public Pedido(Cliente cliente, String nomeCliente) throws IllegalArgumentException {
        if (nomeCliente == null) throw new IllegalArgumentException("O nome do cliente não pode ser nulo");
        this.nomeCliente = nomeCliente;
        this.itensPedido = new LinkedList<>();
    }

    protected Pedido() {}

    public List<ItemPedido> getItens() { return Collections.unmodifiableList(itensPedido); }
    public boolean removeItem(ItemPedido item) { return itensPedido.remove(item); }
    public boolean addItem(ItemPedido item) { return itensPedido.add(item); }
    public String getNomeCliente() { return nomeCliente; }
    public long getCodigo() { return codigo; }
    public void setOrcamento(Orcamento orcamento) { this.orcamento = orcamento; }
    public LocalDateTime getData() { return orcamento.getData(); }
}