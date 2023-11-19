package br.fds.demo.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fds.demo.Aplicacao.RelatorioClientesMaisCompras_UC;
import br.fds.demo.Aplicacao.RelatorioClientesOrcamentosNaoEfetivados_UC;
import br.fds.demo.Aplicacao.RelatorioProdutosMaisCaros_UC;
import br.fds.demo.Aplicacao.DTOs.ClienteOrcamentosDTO;
import br.fds.demo.Aplicacao.DTOs.ClienteDTO;
import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;

@RestController
@RequestMapping("/statistics")
public class EstatisticaController {
    @Autowired
    private RelatorioProdutosMaisCaros_UC relatorioProdutosMaisCarosUc;
    
    @Autowired
    private RelatorioClientesMaisCompras_UC relatorioClientesMaisComprasUc;

    @Autowired
    private RelatorioClientesOrcamentosNaoEfetivados_UC relatorioClientesOrcamentosNaoEfetivados;

    @GetMapping("/tres-clientes-mais-compras")
    @CrossOrigin("*")
    public List<ClienteDTO> clientesMaisCompras() {
        return relatorioClientesMaisComprasUc.run();
    }

    @GetMapping("/produtos-mais-caros")
    @CrossOrigin("*")
    public List<ProdutoDTO> produtosMaisCaros() {
        return relatorioProdutosMaisCarosUc.run();
    }

    @GetMapping("/tres-clientes-mais-chatos")
    @CrossOrigin("*")
    public List<ClienteOrcamentosDTO> tresClientesMaisChatos() {
        return relatorioClientesOrcamentosNaoEfetivados.run();
    }

}
