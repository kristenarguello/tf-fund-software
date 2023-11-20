package br.fds.demo.Dominio.OpcoesDesconto;

import br.fds.demo.Dominio.Entidades.Cliente;
import br.fds.demo.Dominio.Entidades.Orcamento;
import br.fds.demo.Dominio.Entidades.Pedido;

public class DescontoValorMedio implements IDescontoStrategy {
    // valor medio das ultimas 3 compras superior a 10 mil = 10%, cada 10 mil, 5% adicionais, limite de 30%
    public float calcularDesconto(Pedido pedido) {
        Cliente cli = pedido.getCliente();
        int tam = cli.getPedidos().size();
        System.out.println("AAAAA");
        if (tam < 4) { // pedido atual já está na contagem
            return 0;
        }
        System.out.println("TAM: " + tam);

        Pedido[] aux = cli.getPedidos().toArray(new Pedido[tam]);
        int total = 0;
        for (int i=1; i<4; i++) { //comeca do segundo pois pedido atual é o primeiro
            for (Orcamento orcamento : aux[tam - i].getOrcamentos()) {
                if (orcamento.estaAprovado()) {
                    total += orcamento.getPrecoFinal();
                }
            }
        }
        System.out.println("TOTAL: " + total);

        int media = total / 3;
        if (media > 10000) {
            media -= 10000;
            int adicionais = media / 10000;
            if (adicionais > 4) {
                adicionais = 4;
            }
            return 0.1f + (adicionais * 0.05f);
        }
        return 0.0f;
    }
}
 
