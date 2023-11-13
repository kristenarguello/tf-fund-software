package br.fds.demo.Dominio;

import java.util.List;

import br.fds.demo.Dominio.Entidades.Produto;

public interface IRepProdutos {
    void save(Produto p);

    List<Produto> all();

    // TODO: get by id
}
