package br.fds.demo.Dominio;

import java.util.List;

import br.fds.demo.Dominio.Entidades.Cliente;

public interface IRepClientes {
    List<Cliente> all();
    List<Cliente> topThreeClientes();
}
