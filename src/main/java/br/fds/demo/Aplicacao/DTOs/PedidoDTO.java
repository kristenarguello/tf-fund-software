package br.fds.demo.Aplicacao.DTOs;

import java.util.List;

import br.fds.demo.Dominio.Entidades.ItemPedido;

public class PedidoDTO {
    private long id;
    private List<ItemPedido> itensPedido;
    private long idCliente;
    private String nomeCliente;

    public PedidoDTO(long id, List<ItemPedido> itensPedido, long idCliente, String nomeCliente) {
        this.id = id;
        this.itensPedido = itensPedido;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
    }

    public long getId() {
        return id;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
