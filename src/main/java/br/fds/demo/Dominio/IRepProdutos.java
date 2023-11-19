package br.fds.demo.Dominio;

import java.util.List;

import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;
import br.fds.demo.Dominio.Entidades.Produto;

public interface IRepProdutos {
    void save(Produto p);

    List<Produto> all();
    List<ProdutoDTO> threeMostExpensive(); 

    // TODO: get by id
}
