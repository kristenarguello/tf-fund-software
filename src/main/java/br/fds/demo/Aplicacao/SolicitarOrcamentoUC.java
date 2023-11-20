package br.fds.demo.Aplicacao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fds.demo.Aplicacao.DTOs.OrcamentoDTO;
import br.fds.demo.Dominio.ServicoOrcamento;
import br.fds.demo.Dominio.Entidades.Orcamento;

@Component
public class SolicitarOrcamentoUC {
    @Autowired
    private ServicoOrcamento servicoOrcamento;

   public OrcamentoDTO run (long idPedido){
        Orcamento orcamento = servicoOrcamento.gerarOrcamento(idPedido);
        OrcamentoDTO orcamentoDto = new OrcamentoDTO(orcamento.getId(), orcamento.getPedido().getCliente().getNome(), orcamento.getData(), orcamento.getPercentualImpostoAplicado(), orcamento.getPercentualDescontoAplicado(), orcamento.getSomaPrecoItens(), orcamento.getPrecoFinal(), orcamento.estaAprovado());
        return orcamentoDto;
    }

}
 