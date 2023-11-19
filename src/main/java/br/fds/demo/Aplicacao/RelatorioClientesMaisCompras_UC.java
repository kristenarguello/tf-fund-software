package br.fds.demo.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Aplicacao.DTOs.ClienteDTO;
import br.fds.demo.Dominio.IRepClientes;

@Component
public class RelatorioClientesMaisCompras_UC {
    @Autowired
    private IRepClientes repClientes;
    
    public List<ClienteDTO> run() {
        return repClientes.topThreeClientes();
    }

}
