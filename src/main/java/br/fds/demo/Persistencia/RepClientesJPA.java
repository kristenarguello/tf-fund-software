package br.fds.demo.Persistencia;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.demo.Dominio.IRepClientes;
import br.fds.demo.Dominio.Entidades.Cliente;

@Repository
@Primary
public class RepClientesJPA implements IRepClientes{
    IRepClientesJPA repJPA;

    @Autowired
    public RepClientesJPA(IRepClientesJPA repClientesJPA){
        this.repJPA = repClientesJPA;
    }

    @Override
    public List<Cliente> all(){
        return (List<Cliente>) repJPA.findAll();
    }

    @Override
    public List<Cliente> topThreeClientes(){
        return ((Collection<Cliente>) repJPA.findAll())
                        .stream()
                        .sorted((c1, c2) -> c2.getPedidos().size() - c1.getPedidos().size())
                        .limit(3)
                        .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<Cliente> threeClientsMostNotApprovedBudget() {
        return ((Collection<Cliente>) repJPA.findAll())
                    .stream()
                    .flatMap(c -> c.getPedidos()
                                  .stream()
                                  .filter(p -> !p.getOrcamento().estaAprovado()))
                                  .map(p -> p.getCliente())
                                  .collect(java.util.stream.Collectors.toList())
                    .stream()
                    .sorted((c1, c2) -> c2.getPedidos().size() - c1.getPedidos().size())
                    .limit(3)
                    .collect(java.util.stream.Collectors.toList());
                    //IT IS WRONG!!!!!! logic still not working
    }

  

    




    
}
