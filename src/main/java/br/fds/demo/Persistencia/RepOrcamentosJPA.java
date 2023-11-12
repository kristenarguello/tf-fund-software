package br.fds.demo.Persistencia;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.demo.Dominio.IRepOrcamentos;
import br.fds.demo.Dominio.Entidades.Orcamento;

@Repository
@Primary
public class RepOrcamentosJPA implements IRepOrcamentos {
    @Autowired
    private IRepOrcamentosJPA repJpa;

    public Orcamento buscarPorId(long id) {
        Optional<Orcamento> orcamento = repJpa.findById(id);
        return orcamento.isPresent()? orcamento.get() : null;
    }

    public void salvar(Orcamento orcamento) {
        repJpa.save(orcamento);
    }
}
