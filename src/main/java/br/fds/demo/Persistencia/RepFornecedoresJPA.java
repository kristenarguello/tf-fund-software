package br.fds.demo.Persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.demo.Dominio.IRepFornecedores;
import br.fds.demo.Dominio.Entidades.Fornecedor;


@Repository
@Primary
public class RepFornecedoresJPA implements IRepFornecedores {
    IRepFornecedoresJPA repJPA;

    @Autowired
    public RepFornecedoresJPA(IRepFornecedoresJPA repJPA){
        this.repJPA = repJPA;
    }

    @Override
    public List<Fornecedor> all() {
        return repJPA.findAll();
    }

    @Override
    public Fornecedor getFornecedor(String nome) {
        return repJPA.findAll()
                     .stream()
                     .filter(f -> f.getNome().equalsIgnoreCase(nome))
                     .findFirst()
                     .orElse( new Fornecedor(-1, nome));
                     
    }


}