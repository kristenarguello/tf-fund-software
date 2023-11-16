package br.fds.demo.Persistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.fds.demo.Dominio.Entidades.Cliente;


public interface IRepClientesJPA extends CrudRepository<Cliente,Long>{
    List<Cliente> all();
    List <Cliente> topThreeClientes();
}