package br.fds.demo.Dominio;

import java.util.List;

import br.fds.demo.Entidades.Fornecedor;


public  interface IRepFornecedores {
    List<Fornecedor> all();
    Fornecedor getFornecedor(String nome);
}
