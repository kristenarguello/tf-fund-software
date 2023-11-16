package br.fds.demo.Aplicacao.DTOs;

public class ProdutoDTO {
    private long codigo;
    private String descricao;
    private double precoUnitario;
    private int quantidadeAtual;

    public ProdutoDTO(long codigo, String descricao, double preco, int qtd) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnitario = preco;
        this.quantidadeAtual = qtd;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }
}
