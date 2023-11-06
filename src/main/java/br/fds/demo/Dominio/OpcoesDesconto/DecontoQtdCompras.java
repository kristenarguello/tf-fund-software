package br.fds.demo.Dominio.OpcoesDesconto;

import br.fds.demo.Dominio.Entidades.Pedido;

//TODO
public class DecontoQtdCompras implements IDescontoStrategy {
    public float calcularDesconto(Pedido pedido) {
        if (pedido.getCliente().getQtdComprasUltimos6Meses() > 10) {
            // return pedido.getValorTotal() * 0.25f;
            return 0;
        }
        // return pedido.getValorTotal(); //nao tem desconto, retorna o valor normal? maybe just return the percentage
        return 0;
    }
    // 25% de desconto para clientes com mais de 10 compras nos ultimos 6 meses
}
