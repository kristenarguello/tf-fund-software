package br.fds.demo.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Aplicacao.DTOs.ClienteOrcamentosDTO;
import br.fds.demo.Dominio.IRepClientes;

@Component
public class RelatorioClientesOrcamentosNaoEfetivados_UC {
    @Autowired
    private IRepClientes repClientes;
    
    public List<ClienteOrcamentosDTO> run() {
        return repClientes.threeClientsMostNotApprovedBudget();
    }

}
