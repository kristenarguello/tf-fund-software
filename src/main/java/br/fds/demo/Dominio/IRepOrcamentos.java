package br.fds.demo.Dominio;

import br.fds.demo.Dominio.Entidades.Orcamento;

public interface IRepOrcamentos {
    Orcamento buscarPorId(long id);
    void salvar(Orcamento orcamento);
}
