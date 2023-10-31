package br.fds.demo.Persistencia;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.fds.demo.Dominio.Entidades.Fornecedor;


public interface IRepFornecedoresJPA extends CrudRepository<Fornecedor,Long>{
      List<Fornecedor> findAll();

  //    Fornecedor getByNomeFornecedor(String nome);
}
