package br.fds.demo.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Produto {
    @Id 
    private long codigo;
    private String descricao;
    private double preco;

    public Produto(long codigo, String descricao,double preco, Fornecedor fornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.fornecedor = fornecedor;
    }

    protected Produto(){}
    
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @JsonBackReference
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo 
                + ", descricao=" + descricao + ", preco=" + preco 
                + fornecedor.toString()
                + "]";
    }
}
