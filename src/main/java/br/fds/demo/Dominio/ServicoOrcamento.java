package br.fds.demo.Dominio;

import br.fds.demo.Dominio.Entidades.Pedido;
import br.fds.demo.Dominio.Entidades.ItemPedido;
import br.fds.demo.Dominio.Entidades.Orcamento;
import br.fds.demo.Dominio.OpcoesDesconto.FabricaDeDescontos;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicoOrcamento {
    public static final int DIAS_VALIDADE_BAIXA_PROCURA = 21;
    public static final int DIAS_VALIDADE_ALTA_PROCURA = 35;
    @Autowired
    private IRepOrcamentos repOrcamentos;

    @Autowired
    private FabricaDeDescontos fabricaDeDescontos;

    public void efetivarOrcamento(long id) throws ResponseStatusException {
        // obter a entidade do orcamento
        Orcamento orcamento = repOrcamentos.buscarPorId(id);
        if (orcamento == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O orçamento não pôde ser encontrado");

        // validar as datas dos orcamentos
        long diasDesdeEmissaoOrcamento = Duration.between(LocalDateTime.now(), orcamento.getData()).toDays();
        int diasValidadeOrcamento = calcularDiasValidade(orcamento);
        if (diasDesdeEmissaoOrcamento > diasValidadeOrcamento)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O orçamento está vencido");

        // validar se ha produtos o suficiente
        for (ItemPedido ip : orcamento.getPedido().getItens()) {
            int qtdAtualProduto = ip.getProduto().getEstoque().getQtdAtual();
            if (qtdAtualProduto < ip.getQuantidade()) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                        String.format("No momento, o produto de descrição '%s' não possui unidades suficientes",
                                ip.getProduto().getDescricao()));
            }
            ip.getProduto().getEstoque().setQtdAtual(qtdAtualProduto - ip.getQuantidade());
        }

        // tudo ocorreu corretamente. marcar orcamento como aprovado e salvar no banco
        // de dados
        orcamento.aprovarOrcamento();
        repOrcamentos.salvar(orcamento);
    }

    private int calcularDiasValidade(Orcamento orcamento) {
        int mesEmissao = orcamento.getData().getMonthValue();
        return mesEmissao == 12 || mesEmissao == 1 || mesEmissao == 2 || mesEmissao == 7 ? DIAS_VALIDADE_BAIXA_PROCURA
                : DIAS_VALIDADE_ALTA_PROCURA;
    }

    public void gerarOrcamento(Pedido Pedido) {
        float percentualDesconto = fabricaDeDescontos.getDesconto(Pedido);
        Orcamento orcamento = new Orcamento(Pedido, 0.10f, percentualDesconto);
        repOrcamentos.salvar(orcamento);
    }
}
