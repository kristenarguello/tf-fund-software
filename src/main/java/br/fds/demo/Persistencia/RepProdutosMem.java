package br.fds.demo.Persistencia;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;
import br.fds.demo.Dominio.IRepProdutos;
import br.fds.demo.Dominio.Entidades.Produto;

@Repository
public class RepProdutosMem implements IRepProdutos {
    private List<Produto> produtos;

    public RepProdutosMem(){
        produtos = new LinkedList<>();
//        produtos.add(new Produto(10,"banana",3.5));
//        produtos.add(new Produto(20,"maca",5.0));
    }

    @Override
    public void save(Produto p) {
    
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Produto> all() {
        return produtos;
    }

    @Override
    public List<ProdutoDTO> threeMostExpensive() {
        throw new UnsupportedOperationException("Unimplemented method 'threeMostExpensive'");
    }
    
}
