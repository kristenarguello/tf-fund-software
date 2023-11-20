package br.fds.demo.Aplicacao.DTOs;
import java.time.LocalDateTime;


public class OrcamentoDTO {
    private long id;
    private String nomeCliente;
    private LocalDateTime data;
    private float percentualImpostoAplicado;
    private float percentualDescontoAplicado;
    private double somaPrecoItens;
    private double precoFinal;
    private boolean aprovado;

    public OrcamentoDTO( long id, String nomeCliente, LocalDateTime data, float percentualImposto, float percentualDesconto, double somaPrecoItens ,double precoFinal, boolean aprovado ){
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.percentualImpostoAplicado = percentualImposto;
        this.percentualDescontoAplicado = percentualDesconto;
        this.somaPrecoItens = somaPrecoItens;
        this.precoFinal = precoFinal;
        this.aprovado = aprovado;
    }

    public long getId() { return id; }
    public String getNomeCliente() { return nomeCliente; }
    public LocalDateTime getData() { return data; }
    public float getPercentualImpostoAplicado() { return percentualImpostoAplicado; }
    public float getPercentualDescontoAplicado() { return percentualDescontoAplicado; }
    public double getSomaPrecoItens() { return somaPrecoItens; }
    public double getPrecoFinal() { return precoFinal; }
    public boolean estaAprovado() { return aprovado; }

    public void setData(LocalDateTime data) { this.data = data; }
    public void setPercentualImpostoAplicado(float percentualImpostoAplicado) { this.percentualImpostoAplicado = percentualImpostoAplicado; }
    public void setPercentualDescontoAplicado(float percentualDescontoAplicado) { this.percentualDescontoAplicado = percentualDescontoAplicado; }
    public void setSomaPrecoItens(double somaPrecoItens) { this.somaPrecoItens = somaPrecoItens; }
    public void setPrecoFinal(double precoFinal) { this.precoFinal = precoFinal; }
    public void setAprovado(boolean aprovado) { this.aprovado = aprovado; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setId(long id) { this.id = id; }

}
