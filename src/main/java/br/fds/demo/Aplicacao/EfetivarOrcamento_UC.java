package br.fds.demo.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Dominio.ServicoOrcamento;

@Component
public class EfetivarOrcamento_UC {
    @Autowired
    private ServicoOrcamento servicoOrcamento;
    
    public void run(long idOrcamento) {
        servicoOrcamento.efetivarOrcamento(idOrcamento);
    }
}
