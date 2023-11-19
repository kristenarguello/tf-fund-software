package br.fds.demo.Persistencia;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.demo.Aplicacao.DTOs.ClienteDTO;
import br.fds.demo.Aplicacao.DTOs.ClienteOrcamentosDTO;
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
    public List<ClienteDTO> topThreeClientes(){
        return all()
                .stream()
                .sorted((c1, c2) -> c2.getPedidos().size() - c1.getPedidos().size())
                .limit(3)
                .map(c -> new ClienteDTO(c.getNome(), c.getPedidos().size()))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<ClienteOrcamentosDTO> threeClientsMostNotApprovedBudget() {
        Map<Cliente, Long> aux = new HashMap<>();
        // get amount of not approved budgets for each client
        ((Collection<Cliente>) repJPA.findAll())
                .stream()
                .forEach(c -> {
                    long pedidos_nao_aprovados = c.getPedidos()
                                    .stream()
                                    .filter(p -> !p.getOrcamento().estaAprovado())
                                    .count();
                    aux.put(c, pedidos_nao_aprovados);
                }
        );       

        // return the top 3 ones
        return aux.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .limit(3)
            .map(cv -> new ClienteOrcamentosDTO(cv.getKey().getNome(), cv.getValue()))
            .collect(java.util.stream.Collectors.toList());
    }
  
}
