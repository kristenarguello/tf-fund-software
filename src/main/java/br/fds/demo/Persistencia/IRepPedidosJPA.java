package br.fds.demo.Persistencia;

import org.springframework.data.repository.CrudRepository;

import br.fds.demo.Dominio.Entidades.Pedido;


public interface  IRepPedidosJPA extends  CrudRepository<Pedido,Long>{
    
}
