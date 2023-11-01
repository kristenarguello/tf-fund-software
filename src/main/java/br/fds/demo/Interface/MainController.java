package br.fds.demo.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fds.demo.Aplicacao.BuscaFornecedor_UC;
import br.fds.demo.Aplicacao.ProdutosDisponiveis_UC;
import br.fds.demo.Aplicacao.ProdutosFornecedor_UC;
import br.fds.demo.Dominio.Entidades.Fornecedor;
import br.fds.demo.Dominio.Entidades.Produto;

@RestController
@RequestMapping("/api")
public class MainController {
    
    private ProdutosDisponiveis_UC produtosDisponiveis_UC;
    private ProdutosFornecedor_UC produtosFornecedor_UC;
    private BuscaFornecedor_UC buscaFornecedor_UC;

    @Autowired
    public MainController(ProdutosDisponiveis_UC produtosDisponiveis_UC,
                    ProdutosFornecedor_UC produtosFornecedor_UC,
                    BuscaFornecedor_UC buscaFornecedor_UC) {
                        this.produtosDisponiveis_UC = produtosDisponiveis_UC;
                        this.produtosFornecedor_UC = produtosFornecedor_UC;
                        this.buscaFornecedor_UC = buscaFornecedor_UC;


                    }
    

    @GetMapping("/produtosDisponiveis")
    @CrossOrigin("*")
    public List<Produto> produtosDisponiveis(){
        var lista = produtosDisponiveis_UC.run();
        System.out.println("\n- - - - - - -");
        for (Produto p : lista) {
            System.out.printf("%s-%s\n",p.getDescricao(), p.getFornecedor().getNome());
        }
        System.out.println("\n- - - - - - -");
        return lista;
    }

    @GetMapping("/getFornecedor")
    @CrossOrigin("*")
    public Fornecedor getFornecedor(String nome){
        return buscaFornecedor_UC.run(nome);
    }

    @GetMapping("/getFornecedor2/{nome}")
    @CrossOrigin("*")
    public Fornecedor getFornecedor2(@PathVariable("nome") String fornecedor){
        return buscaFornecedor_UC.run(fornecedor);
    }
    
    @GetMapping("/getFornecedores")
    @CrossOrigin("*")
    public List<Fornecedor> getFornededores(){
        return produtosFornecedor_UC.run();
    }
}
