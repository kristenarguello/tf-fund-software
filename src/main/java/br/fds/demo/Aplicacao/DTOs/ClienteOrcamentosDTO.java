package br.fds.demo.Aplicacao.DTOs;

public class ClienteOrcamentosDTO {
    private String nome;
    private long qtdOrcamentosNaoAprovados;

    public ClienteOrcamentosDTO(String nome, long qtdOrcamentosNaoAprovados) {
        this.nome = nome;
        this.qtdOrcamentosNaoAprovados = qtdOrcamentosNaoAprovados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getQtdOrcamentosNaoAprovados() {
        return qtdOrcamentosNaoAprovados;
    }

    public void setQtdOrcamentosNaoAprovados(long qtdOrcamentosNaoAprovados) {
        this.qtdOrcamentosNaoAprovados = qtdOrcamentosNaoAprovados;
    }

}   
    