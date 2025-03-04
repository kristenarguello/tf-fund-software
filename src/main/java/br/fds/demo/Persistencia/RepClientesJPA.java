package br.fds.demo.Persistencia;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.fds.demo.Dominio.IRepClientes;
import br.fds.demo.Dominio.Entidades.Cliente;

@Repository
@Primary
public class RepClientesJPA implements IRepClientes {
    IRepClientesJPA repJPA;

    @Autowired
    public RepClientesJPA(IRepClientesJPA repClientesJPA) {
        this.repJPA = repClientesJPA;
    }

    @Override
    public List<Cliente> all() {
        return (List<Cliente>) repJPA.findAll();
    }

    @Override
    public List<Cliente> topThreeClientes() {
        return all()
                .stream()
                .sorted((c1, c2) -> c2.getPedidos().size() - c1.getPedidos().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public HashMap<Cliente, Long> threeClientsMostNotApprovedBudget() {
        Map<Cliente, Long> aux = new HashMap<>();
        // get amount of not approved budgets for each client
        ((Collection<Cliente>) repJPA.findAll())
                .stream()
                .forEach(c -> {
                    AtomicLong pedidos_nao_aprovados = new AtomicLong(0);
                    c.getPedidos()
                            .forEach(p -> {
                                if (p.getOrcamentos().size() == 0)
                                    return;
                                pedidos_nao_aprovados.addAndGet(p.getOrcamentos()
                                        .stream()
                                        .filter(o -> !o.estaAprovado())
                                        .count());
                                // return !p.getOrcamentos().estaAprovado();
                            });
                    aux.put(c, pedidos_nao_aprovados.get());
                });

        // return the top 3 ones
        return aux.entrySet()
                .stream()
                .sorted(Map.Entry.<Cliente, Long>comparingByValue().reversed())
                .filter(e -> e.getValue() > 0)
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
    }

    @Override
    public Cliente buscarPorId(long id) {
        return repJPA.findById(id).orElse(null);
    }

}
