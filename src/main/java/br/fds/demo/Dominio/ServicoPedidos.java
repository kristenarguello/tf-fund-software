package br.fds.demo.Dominio;

import br.fds.demo.Dominio.Entidades.Pedido;
import br.fds.demo.Dominio.Entidades.Cliente;
import br.fds.demo.Dominio.Entidades.ItemPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicoPedidos {
    @Autowired
    IRepClientes repClientes;

    @Autowired
    private IRepPedidos repPedidos;

    public Pedido geraPedido(List<ItemPedido> itens, long idCliente) {
        Cliente cliente = repClientes.buscarPorId(idCliente);
        if (cliente == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O cliente não pôde ser encontrado");

        Pedido pedido = new Pedido(cliente);
        for (ItemPedido item : itens) {
            item.setPedido(pedido);
            pedido.addItem(item);
        }

        repPedidos.salvar(pedido);
        return pedido;
    }

}