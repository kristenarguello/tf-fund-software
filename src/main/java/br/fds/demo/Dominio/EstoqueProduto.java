package br.fds.demo.Dominio;
import br.fds.demo.Dominio.Entidades.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class EstoqueProduto {
    
    @Id
    private long codigo;


    private int quantidadeMax;
    private int quantidadeMin;
    private int quantidadeAtual;

    public EstoqueProduto(long codigo, int quantidadeMax, int quantidadeMin, int quantidadeAtual) {
        this.codigo = codigo;
        this.quantidadeMax = quantidadeMax;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeAtual = quantidadeAtual;
    }

    @OneToOne
    @JoinColumn(name = "produto_codigo")
    private Produto produto;

    protected EstoqueProduto(){}


    public long getCodigo() {
        return codigo;
    }

    public int getQuantidadeMax() {
        return quantidadeMax;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }


}
