package br.fds.demo.Persistencia;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.fds.demo.Dominio.Entidades.Orcamento;

public interface IRepOrcamentosJPA extends CrudRepository<Orcamento,Long> {
    Optional<Orcamento> findById(long id);
    <S extends Orcamento> S save(S orcamento);
}
