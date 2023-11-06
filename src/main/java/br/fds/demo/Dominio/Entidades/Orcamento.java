package br.fds.demo.Dominio.Entidades;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// anotacoes JPA / construtor protected em ItemPedido
// para instanciar o Orcamento, passamos o codigo? inventamos um? ele nao eh gerado pelo BD?
// toda vez eu preciso dar save? quando o JPA salva automaticamente?
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @OneToOne
    private Pedido pedido;

    private LocalDateTime data;
    private float percentualImpostoAplicado;
    private float percentualDescontoAplicado;
    private boolean aprovado;

    public Orcamento(Pedido pedido, float percentualImposto, float percentualDesconto) throws IllegalArgumentException {
        if (pedido == null) 
            throw new IllegalArgumentException("O pedido não pode ser nulo");
        if (percentualImposto < 0.0 || percentualImposto > 100.0) 
            throw new IllegalArgumentException("O percentual de imposto deve ser um valor de 0 a 100");
        if (percentualDesconto < 0.0 || percentualDesconto > 100.0) 
            throw new IllegalArgumentException("O percentual de desconto deve ser um valor de 0 a 100");
        this.pedido = pedido;
        this.data = LocalDateTime.now();
        this.percentualImpostoAplicado = percentualImposto;
        this.percentualDescontoAplicado = percentualDesconto;
        this.aprovado = false;
    }

    protected Orcamento() {}

    public double getSomaPrecoItens() { 
        return getItens()
               .stream()
               .mapToDouble((ItemPedido ip) -> ip.getQuantidade()*ip.getPrecoUnitarioProduto())
               .sum();
    }
    public double getPrecoFinal() { 
        return getSomaPrecoItens() * (1-percentualDescontoAplicado) * (1-percentualImpostoAplicado); 
    }
    public Cliente getCliente() { return pedido.getCliente(); }
    public List<ItemPedido> getItens() { return pedido.getItens(); }
    public void aprovarOrcamento() { aprovado = true; }
    public boolean estaAprovado() { return aprovado; }
    public LocalDateTime getData() { return data; }
    public long getCodigo() { return codigo; }
}