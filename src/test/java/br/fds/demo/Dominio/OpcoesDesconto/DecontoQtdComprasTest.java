package br.fds.demo.Dominio.OpcoesDesconto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.fds.demo.Dominio.Entidades.Cliente;
import br.fds.demo.Dominio.Entidades.ItemPedido;
import br.fds.demo.Dominio.Entidades.Orcamento;
import br.fds.demo.Dominio.Entidades.Pedido;
import br.fds.demo.Dominio.Entidades.Produto;

public class DecontoQtdComprasTest {
    private static IDescontoStrategy implDesconto;

    @BeforeAll
    public static void setup() {
        implDesconto = new DecontoQtdCompras();
    }

    @Test
    public void testeMenosDeDezPedidos() {
        // cria duble de cliente
        Cliente cli = new Cliente("Frederico");

        // cria duble de pedido
        Pedido ped = new Pedido(cli);

        // adiciona um item ao pedido
        Produto prodTest = new Produto("Teste", 100.0, 100, 10, 50);
        ped.addItem(new ItemPedido(10, prodTest));

        // associa o pedido ao cliente
        cli.addPedido(ped);

        // cria e associa um orcamento aprovado ao pedido
        Orcamento orc = new Orcamento(ped, 0, 0);
        orc.aprovarOrcamento();
        ped.addOrcamento(orc);


        // garante que o desconto é zero, pois o cliente tem apenas um pedido
        Assertions.assertEquals(0, implDesconto.calcularDesconto(ped));
    }

    @Test
    public void testeMaisDeDezPedidos() {
        // cria duble de cliente
        Cliente cli = new Cliente("Frederico");

        // cria duble de produto
        Produto prodTest = new Produto("Teste", 100.0, 100, 10, 50);
        

        // cria dubles de pedidos e associa ao cliente
        for (int i=0; i<12; i++) {
            Pedido ped = new Pedido(cli);
            ped.addItem(new ItemPedido(2, prodTest));
            cli.addPedido(ped);

            // cria duble de orcamento e associa ao pedido
            Orcamento ord = new Orcamento(ped, 0, 0);
            // aprova o orcamento apra contabilizar 
            ord.aprovarOrcamento();
            ped.addOrcamento(ord);
        }


        // garante desconto de 25%, pois o cliente tem 12 pedidos
        Pedido ultimoPedido = (Pedido) cli.getPedidos().toArray()[11];
        Assertions.assertEquals(0.25, implDesconto.calcularDesconto(ultimoPedido));
    }
}
