package br.fds.demo.Aplicacao.DTOs;

public class ClienteDTO {
    private String nome;
    private long qtdPedidos;

    public ClienteDTO(String nome, long qtdPedidos) {
        this.nome = nome;
        this.qtdPedidos = qtdPedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getqtdPedidos() {
        return qtdPedidos;
    }

    public void setqtdPedidos(long qtdPedidos) {
        this.qtdPedidos = qtdPedidos;
    }

}   
    