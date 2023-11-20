package br.fds.demo.Dominio.OpcoesDesconto;

import br.fds.demo.Dominio.Entidades.Pedido;

public interface IDescontoStrategy {
    float calcularDesconto(Pedido pedido);
}
