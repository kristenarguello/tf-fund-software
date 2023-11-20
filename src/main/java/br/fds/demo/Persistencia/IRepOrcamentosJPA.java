package br.fds.demo.Persistencia;

import org.springframework.data.repository.CrudRepository;

import br.fds.demo.Dominio.Entidades.Orcamento;

public interface IRepOrcamentosJPA extends CrudRepository<Orcamento,Long> {

} 
