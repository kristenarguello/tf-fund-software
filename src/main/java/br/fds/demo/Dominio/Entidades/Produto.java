package br.fds.demo.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.fds.demo.Dominio.EstoqueProduto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Produto {
    @Id 
    private long codigo;
    private String descricao;
    private double precoUnitario;
    
    public Produto(long codigo, String descricao,double precoUnitario, Fornecedor fornecedor, EstoqueProduto estoqueProduto) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.fornecedor = fornecedor;
        this.estoqueProduto = estoqueProduto;
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

    @OneToOne(mappedBy = "produto")
    @JsonBackReference
    private EstoqueProduto estoqueProduto;
    public EstoqueProduto getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(EstoqueProduto estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }


    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo 
                + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario 
                + fornecedor.toString()
                + "]";
    }
}
