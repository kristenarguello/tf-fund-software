package br.fds.demo.Dominio.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private int qtdAtual;
    private int qtdMax;
    private int qtdMin;

    public Estoque(int qtdAtual, int qtdMax, int qtdMin) {
        this.qtdAtual = qtdAtual;
        this.qtdMax = qtdMax;
        this.qtdMin = qtdMin;
    }

    protected Estoque() {}
    
    public int getQtdAtual() { return qtdAtual; }
    public void setQtdAtual(int qtdAtual) { this.qtdAtual = qtdAtual; }
    public int getQtdMax() { return qtdMax; }
    public void setQtdMax(int qtdMax) { this.qtdMax = qtdMax; }
    public int getQtdMin() { return qtdMin; }
    public void setQtdMin(int qtdMin) { this.qtdMin = qtdMin; }
}
