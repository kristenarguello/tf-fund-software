package br.fds.demo.Aplicacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Aplicacao.DTOs.ItemPedidoDTO;
import br.fds.demo.Aplicacao.DTOs.PedidoDTO;
import br.fds.demo.Dominio.IRepProdutos;
import br.fds.demo.Dominio.ServicoPedidos;
import br.fds.demo.Dominio.Entidades.ItemPedido;
import br.fds.demo.Dominio.Entidades.Pedido;
import br.fds.demo.Dominio.Entidades.Produto;

@Component
public class SolicitarPedidoUC {
    @Autowired
    private IRepProdutos repProdutos;

    @Autowired
    private ServicoPedidos servicoPedidos;

    public PedidoDTO run(List<ItemPedidoDTO> itens, long idCliente) {
        List<ItemPedido> intensPedido = new ArrayList<ItemPedido>();
        for (ItemPedidoDTO item : itens) {
            if (item.getQuantidade() > 0) {
                Produto produto = repProdutos.buscarPorId(item.getIdProduto());
                if (produto != null)
                    intensPedido.add(new ItemPedido(item.getQuantidade(), produto));
            }
        }

        Pedido pedido = servicoPedidos.geraPedido(intensPedido, idCliente);
        return new PedidoDTO(pedido.getId(), pedido.getCliente().getId(),
                pedido.getCliente().getNome());
    }

}
