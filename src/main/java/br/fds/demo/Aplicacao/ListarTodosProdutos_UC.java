package br.fds.demo.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;
import br.fds.demo.Persistencia.RepProdutosJPA;

@Component
public class ListarTodosProdutos_UC {
    @Autowired
    private RepProdutosJPA repProdutosJPA;

    public List<ProdutoDTO> run(){
        return repProdutosJPA.allAvailable();
    }
}


