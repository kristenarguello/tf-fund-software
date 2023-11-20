package br.fds.demo.Dominio.OpcoesDesconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.fds.demo.Dominio.Entidades.Cliente;
import br.fds.demo.Dominio.Entidades.ItemPedido;
import br.fds.demo.Dominio.Entidades.Orcamento;
import br.fds.demo.Dominio.Entidades.Pedido;
import br.fds.demo.Dominio.Entidades.Produto;

public class DescontoValorMedioTest {
    private static IDescontoStrategy implDesconto;

    @BeforeAll
    public static void setup() {
        implDesconto = new DescontoValorMedio();
    }

    @Test
    public void valorMedioUltimas3ComprasAcima10mil() {
        Cliente cli = new Cliente("Joe Doe");   
        Produto prodTest = new Produto("Teste", 10000.0, 100, 10, 50);
        for (int i=0; i<3; i++) {
            Pedido ped = new Pedido(cli);
            ped.addItem(new ItemPedido(2, prodTest));
            cli.addPedido(ped);

            Orcamento orc = new Orcamento(ped, 0, 0);
            orc.aprovarOrcamento();
            ped.addOrcamento(orc);
        }

        Pedido pedidoTeste = new Pedido(cli);
        pedidoTeste.addItem(new ItemPedido(2, prodTest));
        cli.addPedido(pedidoTeste);
        System.out.println("AQUI" + cli.getPedidos().size());
        Assertions.assertEquals(0.1, implDesconto.calcularDesconto(pedidoTeste));
    }

    @Test
    public void menosDe3comprasAnteriores() {
        Cliente cli = new Cliente("Rosangela");   
        Produto prodTest = new Produto("Teste", 100.0, 100, 10, 50);
        for (int i=0; i<2; i++) {
            Pedido ped = new Pedido(cli);
            ped.addItem(new ItemPedido(2, prodTest));
            cli.addPedido(ped);

            Orcamento orc = new Orcamento(ped, 0, 0);
            orc.aprovarOrcamento();
            ped.addOrcamento(orc);
        }

        Pedido pedidoTeste = new Pedido(cli);
        pedidoTeste.addItem(new ItemPedido(2, prodTest));
        cli.addPedido(pedidoTeste);
        Assertions.assertEquals(0.0, implDesconto.calcularDesconto(pedidoTeste));
    }

}
