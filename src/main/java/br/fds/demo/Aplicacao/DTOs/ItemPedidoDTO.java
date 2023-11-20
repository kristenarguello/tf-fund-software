package br.fds.demo.Aplicacao.DTOs;

public class ItemPedidoDTO {
    private int quantidade;
    private long idProduto;

    public ItemPedidoDTO(int quantidade, long idProduto) {
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

}
