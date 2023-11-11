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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.LinkedList;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<ItemPedido> itensPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;

    public Pedido(Cliente cliente) throws IllegalArgumentException {
        this.itensPedido = new LinkedList<>();
    }

    protected Pedido() {}
    public long getId() { return id; }
    public List<ItemPedido> getItens() { return Collections.unmodifiableList(itensPedido); }
    public boolean removeItem(ItemPedido item) { return itensPedido.remove(item); }
    public boolean addItem(ItemPedido item) { return itensPedido.add(item); }
    public Cliente getCliente() { return cliente; }
    public void setOrcamento(Orcamento orcamento) { this.orcamento = orcamento; }
    public Orcamento getOrcamento() { return orcamento; }
}