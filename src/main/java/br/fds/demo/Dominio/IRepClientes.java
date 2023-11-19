package br.fds.demo.Dominio;

import java.util.List;

import br.fds.demo.Aplicacao.DTOs.ClienteDTO;
import br.fds.demo.Aplicacao.DTOs.ClienteOrcamentosDTO;
import br.fds.demo.Dominio.Entidades.Cliente;

public interface IRepClientes {
    List<Cliente> all();
    List<ClienteDTO> topThreeClientes();
    List<ClienteOrcamentosDTO> threeClientsMostNotApprovedBudget();

}
