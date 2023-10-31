package br.fds.demo.Dominio;

import java.util.List;

import br.fds.demo.Entidades.Produto;

public  interface IRepProdutos {
    void save(Produto p);
    List<Produto> all();
}
