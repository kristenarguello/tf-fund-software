package br.fds.demo.Dominio.OpcoesDesconto;

import java.time.LocalDateTime;

import br.fds.demo.Dominio.Entidades.Cliente;
import br.fds.demo.Dominio.Entidades.Orcamento;
import br.fds.demo.Dominio.Entidades.Pedido;

public class DecontoQtdCompras implements IDescontoStrategy {
    // 25% de desconto para clientes com mais de 10 compras nos ultimos 6 meses
    public float calcularDesconto(Pedido pedido) {
        Cliente cli = pedido.getCliente();
        int quantidade = cli.getPedidos().size();
        Pedido[] pedidosCliente = cli.getPedidos().toArray(new Pedido[quantidade]);

        int comprasUltimos6Meses = 0;
        for (int i=quantidade - 1; i>=0; i--) {
            if (pedidosCliente[i].getOrcamentos().size() == 0) 
                continue;
        
            for (Orcamento orcamento : pedidosCliente[i].getOrcamentos()) {
                if ((orcamento.getData().isAfter(LocalDateTime.now().minusMonths(6)) && orcamento.getData().isBefore(LocalDateTime.now())) && orcamento.estaAprovado()) {
                    comprasUltimos6Meses++;
                }
            }
            
            if (comprasUltimos6Meses == 11) {
                return 0.25f;
            }
        }

        return 0f;
    }
}
