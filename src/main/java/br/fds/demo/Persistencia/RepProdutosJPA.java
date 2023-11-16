package br.fds.demo.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;
import br.fds.demo.Dominio.IRepProdutos;
import br.fds.demo.Dominio.Entidades.Produto;

@Repository
@Primary
public class RepProdutosJPA implements IRepProdutos {
    IRepProdutosJPA repJPA;

    @Autowired
    public RepProdutosJPA(IRepProdutosJPA repJPA) {
        this.repJPA = repJPA;
    }

    @Override
    public void save(Produto p) {
        repJPA.save(p);
    }

    @Override
    public List<Produto> all() {
        return repJPA.findAll();
    }

    public List<ProdutoDTO> threeMostExpensive() {
        // return repJPA.threeMostExpensive();
        return null;
    }

}