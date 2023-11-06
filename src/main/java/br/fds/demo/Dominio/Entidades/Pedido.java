package br.fds.demo.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Pedido {




    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente; //isso aqui é o cliente_id
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
