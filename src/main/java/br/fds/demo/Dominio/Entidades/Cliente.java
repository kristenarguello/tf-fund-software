package br.fds.demo.Dominio.Entidades;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;    
    private int qtdCompras; //maybe list of dates for each order?  sera q precisa?
    //whenever getQtdComprasUltimos6Meses called, and there are orders older than 6 months, remove them from list?
    
    public Cliente(long codigo, String nome, int qtdCompras) {
        this.id = codigo;
        this.nome = nome;
        this.qtdCompras = qtdCompras;
        this.pedidos = new HashSet<>();
    }

    protected Cliente(){}
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cliente_id") //tem que ter dentro de pedido!
    @JsonManagedReference
    private Set<Pedido> pedidos; //mudar pra pilha?

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public int getQtdComprasUltimos6Meses() {
        //tentar iterar de tras pra frente pra otimizar = mais pra tras mais recente, pilha talvez?
        int cont = 0;
        // for (Pedido pedido : pedidos) {
        //     // if (pedido.getData().isBefore(LocalDate.now().minusMonths(6))) {
        //     // cont++;
        //     // }
        // }
        return cont;
    }


    public void incrementarQtdCompras() {
        this.qtdCompras++;
    } 
    //chamar sempre que realizar um pedcodigoo para esse cliente e orcamento for aprovado - sera q precisa?


    public void setcodigo(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdCompras() {
        return qtdCompras;
    }

    public void setQtdCompras(int qtdCompras) {
        this.qtdCompras = qtdCompras;
    }
    

}
