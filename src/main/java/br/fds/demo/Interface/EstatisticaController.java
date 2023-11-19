package br.fds.demo.Interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fds.demo.Aplicacao.RelatorioClientesMaisCompras_UC;
import br.fds.demo.Aplicacao.RelatorioClientesOrcamentosNaoEfetivados_UC;
import br.fds.demo.Aplicacao.RelatorioProdutosMaisCaros_UC;

@RestController
@RequestMapping("/statistics")
public class EstatisticaController {
    @Autowired
    private RelatorioProdutosMaisCaros_UC relatorioProdutosMaisCarosUc;
    
    @Autowired
    private RelatorioClientesMaisCompras_UC relatorioClientesMaisComprasUc;

    @Autowired
    private RelatorioClientesOrcamentosNaoEfetivados_UC relatorioClientesOrcamentosNaoEfetivados;


}
