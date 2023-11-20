package br.fds.demo.Aplicacao.DTOs;

import br.fds.demo.Dominio.Entidades.Produto;

public class ItemPedidoDTO {
    private int quantidade;
    private Produto produto;

    public ItemPedidoDTO(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
