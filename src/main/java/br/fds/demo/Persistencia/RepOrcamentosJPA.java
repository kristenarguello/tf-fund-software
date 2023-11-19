package br.fds.demo.Persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.demo.Dominio.IRepOrcamentos;
import br.fds.demo.Dominio.Entidades.Orcamento;

@Repository
@Primary
public class RepOrcamentosJPA implements IRepOrcamentos {
    IRepOrcamentosJPA repJPA;

    @Autowired
    public RepOrcamentosJPA(IRepOrcamentosJPA repJPA){
        this.repJPA = repJPA;
    }

    @Override
    public Orcamento buscarPorId(long id) {
        return repJPA.findById(id).orElse(null);
    }

    @Override
    public void salvar(Orcamento orcamento) {
        repJPA.save(orcamento);
    }

}
