
package br.fds.demo.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Dominio.ServicoEstoque;
import br.fds.demo.Entidades.Fornecedor;


@Component
public class BuscaFornecedor_UC {
 
    @Autowired
    private ServicoEstoque servicoEstoque;


    public Fornecedor run(String fornecedor){
       return servicoEstoque.getFornecedor(fornecedor);
    }
}
