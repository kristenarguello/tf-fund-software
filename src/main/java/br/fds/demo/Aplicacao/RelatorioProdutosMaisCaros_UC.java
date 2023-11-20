package br.fds.demo.Aplicacao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;
import br.fds.demo.Dominio.IRepProdutos;

@Component
public class RelatorioProdutosMaisCaros_UC {
    @Autowired
    private IRepProdutos produtosRep;

    public List<ProdutoDTO> run() {
        return produtosRep.threeMostExpensive()
                        .stream()
                        .map(p -> new ProdutoDTO(p.getId(), p.getDescricao(), p.getPrecoUnitario(), p.getQtdAtual()))
                        .collect(Collectors.toList());
    }
}     
