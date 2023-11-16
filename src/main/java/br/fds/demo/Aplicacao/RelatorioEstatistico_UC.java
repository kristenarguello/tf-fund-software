package br.fds.demo.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Dominio.ServicoEstatistico;

@Component
public class RelatorioEstatistico_UC {
    @Autowired
    private ServicoEstatistico servicoEstatistico;

    
}

