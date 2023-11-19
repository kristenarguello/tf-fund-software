package br.fds.demo.Dominio;

import br.fds.demo.Dominio.Entidades.Pedido;

public interface IRepPedidos {
    Pedido buscarPorId(long id);
    void salvar(Pedido pedido);
    
}