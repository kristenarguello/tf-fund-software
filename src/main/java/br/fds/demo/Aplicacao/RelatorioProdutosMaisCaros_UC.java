package br.fds.demo.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;
import br.fds.demo.Dominio.IRepProdutos;

@Component
public class RelatorioProdutosMaisCaros_UC {
    @Autowired
    private IRepProdutos produtosRep;
    
    public List<ProdutoDTO> run() {
        return produtosRep.threeMostExpensive();
    }
}

