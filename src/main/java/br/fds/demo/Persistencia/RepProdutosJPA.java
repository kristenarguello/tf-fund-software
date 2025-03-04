package br.fds.demo.Persistencia;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

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

    @Override
    public List<Produto> threeMostExpensive() {
        return repJPA.findAll()
                .stream()
                .filter(p -> p.getQtdAtual() > 0)
                // .map(p -> new ProdutoDTO(p.getId(), p.getDescricao(), p.getPrecoUnitario(),
                // p.getQtdAtual()))
                .sorted((p1, p2) -> Double.compare(p2.getPrecoUnitario(), p1.getPrecoUnitario()))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produto> allAvailable() {
        return repJPA.findAll()
                .stream()
                .filter(p -> p.getQtdAtual() > 0)
                // .map(p -> new ProdutoDTO(p.getId(), p.getDescricao(), p.getPrecoUnitario(),
                // p.getQtdAtual()))
                .collect(Collectors.toList());
    }

    @Override
    public Produto buscarPorId(long id) {
        return repJPA.findById(id).orElse(null);
    }
}