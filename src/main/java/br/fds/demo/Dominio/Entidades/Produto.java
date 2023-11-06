package br.fds.demo.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

// import br.fds.demo.Dominio.EstoqueProduto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;


@Entity
public class Produto {
    @Id 
    private long codigo;
    private String descricao;
    private double precoUnitario;

    private int qtdMax;
    private int qtdMin;
    private int qtdAtual;
    
    public Produto(long codigo, String descricao, double precoUnitario, int qtdMax, int qtdMin,int qtdAtual, Fornecedor fornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.fornecedor = fornecedor;
        this.qtdMax = qtdMax;
        this.qtdMin = qtdMin;
        this.qtdAtual = qtdAtual;
    }
    
    protected Produto(){}
    
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @JsonBackReference
    private Fornecedor fornecedor;
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setPrecoUnitario(long precoUnitario){
        this.precoUnitario = precoUnitario;
    }
    
    public double getPrecoUnitario() {
        return precoUnitario;
    }
    
    public void setQtdMax(int qtdMax){
        this.qtdMax = qtdMax;
    }
    
    public int getQtdMax() {
        return qtdMax;
    }
    
    public void setQtdMin(int qtdMin){
        this.qtdMin = qtdMin;
    }
    
    public int getQtdMin() {
        return qtdMin;
    }

    public void setQtdAtual(int qtdAtual){
        this.qtdAtual = qtdAtual;
    }
    
    public int getQtdAtual() {
        return qtdAtual;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario
                + ", qtdMax=" + qtdMax + ", qtdMin=" + qtdMin + ", qtdAtual=" + qtdAtual + ", fornecedor=" + fornecedor
                + "]";
    }
}
