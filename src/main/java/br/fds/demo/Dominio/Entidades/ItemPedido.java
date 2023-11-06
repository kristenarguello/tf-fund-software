package br.fds.demo.Dominio.Entidades;

public class ItemPedido {
    private int quantidade;
    private Produto produto;

    public ItemPedido(int quantidade, Produto produto) throws IllegalArgumentException {
        if (quantidade <= 0) throw new IllegalArgumentException("A quantidade do produto deve ser um valor positivo");
        if (produto == null) throw new IllegalArgumentException("O produto não pode ser nulo");
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}