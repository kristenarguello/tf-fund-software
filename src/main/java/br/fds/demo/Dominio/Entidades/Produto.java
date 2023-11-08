package br.fds.demo.Dominio.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String descricao;
    private double precoUnitario;
    private int qtdMax;
    private int qtdMin;
    private int qtdAtual;
    
    public Produto(String descricao, double precoUnitario, int qtdMax, int qtdMin,int qtdAtual) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.qtdMax = qtdMax;
        this.qtdMin = qtdMin;
        this.qtdAtual = qtdAtual;
    }
    
    protected Produto(){}

    public long getCodigo() { return codigo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
    public int getQtdMax() { return qtdMax; }
    public void setQtdMax(int qtdMax) { this.qtdMax = qtdMax; }
    public int getQtdMin() { return qtdMin; }
    public void setQtdMin(int qtdMin) { this.qtdMax = qtdMin; }
    public int getQtdAtual() { return qtdAtual; }
    public void setQtdAtual(int qtdAtual) { this.qtdAtual = qtdAtual; }
    
    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario
                + ", qtdMax=" + qtdMax + ", qtdMin=" + qtdMin + ", qtdAtual=" + qtdAtual + "]";
    }
}