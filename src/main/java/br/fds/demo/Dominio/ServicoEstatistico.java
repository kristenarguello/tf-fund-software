package br.fds.demo.Dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.fds.demo.Persistencia.RepClientesJPA;
import br.fds.demo.Persistencia.RepOrcamentosJPA;
import br.fds.demo.Persistencia.RepProdutosJPA;

@Service
public class ServicoEstatistico {
    @Autowired
    private RepProdutosJPA produtosRep;

    @Autowired
    private RepClientesJPA clientesRep;

    @Autowired
    private RepOrcamentosJPA orcamentosRep;


}
