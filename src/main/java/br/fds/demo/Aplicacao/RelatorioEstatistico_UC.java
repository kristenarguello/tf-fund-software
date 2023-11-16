package br.fds.demo.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Persistencia.RepClientesJPA;
import br.fds.demo.Persistencia.RepOrcamentosJPA;
import br.fds.demo.Persistencia.RepProdutosJPA;

@Component
public class RelatorioEstatistico_UC {
    @Autowired
    private RepProdutosJPA produtosRep;

    @Autowired
    private RepClientesJPA clientesRep;

    @Autowired
    private RepOrcamentosJPA orcamentosRep;

}

