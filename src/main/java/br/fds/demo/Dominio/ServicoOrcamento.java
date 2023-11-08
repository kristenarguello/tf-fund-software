package br.fds.demo.Dominio;

import br.fds.demo.Dominio.Entidades.Cliente;
import br.fds.demo.Dominio.Entidades.Orcamento;
import br.fds.demo.Dominio.Entidades.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoOrcamento {
    private Orcamento orcamento;

    @Autowired
    public ServicoOrcamento(Pedido pedido, float percentualImposto, float percentualDesconto) {
        this.orcamento = new Orcamento(pedido, percentualImposto, percentualDesconto);
    }

}
