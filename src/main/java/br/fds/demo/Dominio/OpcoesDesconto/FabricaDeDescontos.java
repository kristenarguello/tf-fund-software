package br.fds.demo.Dominio.OpcoesDesconto;

import org.springframework.stereotype.Component;

import br.fds.demo.Dominio.Entidades.Pedido;

@Component
public class FabricaDeDescontos {

    public float getDesconto(Pedido pedido) {
        float descontoValorMedio = new DescontoValorMedio().calcularDesconto(pedido);
        float descontoQtdCompras = new DecontoQtdCompras().calcularDesconto(pedido);
        float percentualDesconto = descontoValorMedio > descontoQtdCompras ? descontoValorMedio : descontoQtdCompras;
        return percentualDesconto;
    }
}
