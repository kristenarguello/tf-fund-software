package br.fds.demo.Aplicacao.DTOs;

public class PedidoDTO {
    private long idPedido;
    private long idCliente;
    private String nomeCliente;

    public PedidoDTO(long idPedido, long idCliente, String nomeCliente) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
