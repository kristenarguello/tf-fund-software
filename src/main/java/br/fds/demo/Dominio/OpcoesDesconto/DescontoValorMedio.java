package br.fds.demo.Dominio.OpcoesDesconto;

import br.fds.demo.Dominio.Entidades.Cliente;
import br.fds.demo.Dominio.Entidades.Pedido;

public class DescontoValorMedio implements IDescontoStrategy {
    // TODO: change all return 0 to real implementations commented
    public float calcularDesconto(Pedido pedido) {
        Cliente cli = pedido.getCliente();
        int tam = cli.getPedidos().size();

        if (tam < 3) {
            // return pedido.getValorTotal();
            return 0;
        }

        // Pedido[] aux = cli.getPedidos().toArray(new Pedido[tam]);
        int total = 0;
        for (int i=1; i<4; i++) {
            // total += aux[tam - i].getValorTotal();
        }
        int media = total / 3;
        
        if (media > 10000) {
            media -= 10000;
            int adicionais = media / 10000;
            if (adicionais > 4) {
                adicionais = 4;
            }
            // return pedido.getValorTotal() * (0.1f + (adicionais * 0.05f));
            return 0;
        }
        // return pedido.getValorTotal();
        return 0;
    }
    // valor medio das ultimas 3 compras superior a 10 mil = 10%, cada 10 mil, 5% adicionais, limite de 30%
}
 
