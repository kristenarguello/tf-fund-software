package br.fds.demo.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Dominio.IRepClientes;
import br.fds.demo.Dominio.Entidades.Cliente;

@Component
public class RelatorioClientesMaisCompras {
    @Autowired
    private IRepClientes repClientes;
    
    public List<Cliente> run() {
        return repClientes.topThreeClientes();
    }

}
