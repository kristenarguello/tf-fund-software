package br.fds.demo.Dominio.Entidades;

import java.util.Collection;

import br.fds.demo.Aplicacao.DTOs.ProdutoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    //@JoinColumn(name = "fornecedor_id")
    //private Set<Produto> produtos;

    public Fornecedor(long id, String nome) {
        this.id = id;
        this.nome = nome;
        //this.produtos = new HashSet<>();
    }

    protected Fornecedor(){}
    
    /*
    public Set<Produto> getProdutos() {
        return produtos;
    }
    
    public void getProdutos(Set<Produto> prods) {
        this.produtos = prods;
    }
    */
    
    public long getCodigo() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return "Produto [codigo=" + id + ", nome=" + nome + "]";
    }

    public Collection<ProdutoDTO> getProdutos() {
        return null;
    }
}
