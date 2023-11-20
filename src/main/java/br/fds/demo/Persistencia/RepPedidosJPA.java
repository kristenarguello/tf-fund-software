package br.fds.demo.Persistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.demo.Dominio.IRepPedidos;
import br.fds.demo.Dominio.Entidades.Pedido;

@Repository
@Primary
public class RepPedidosJPA implements IRepPedidos{
    IRepPedidosJPA repJPA;

    @Autowired
    public RepPedidosJPA(IRepPedidosJPA repJPA){
        this.repJPA = repJPA;
    }

    @Override
    public Pedido buscarPorId(long id) {
        return repJPA.findById(id).orElse(null);
    }

    @Override
    public void salvar(Pedido pedido) {
        repJPA.save(pedido);
    }

}