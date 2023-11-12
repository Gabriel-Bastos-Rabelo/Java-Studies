package models;

public abstract class Bebidas{
    

    protected String nome;
    protected Fornecedor fornecedor;
    protected int estoque;
    protected double valor;
    protected String tipo;

    public Bebidas(String nome, Fornecedor fornecedor, int estoque, double valor, String tipo){
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.estoque = estoque;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getNome(){
        return this.nome;
    }

    public int getEstoque(){
        return this.estoque;
    }

    public Fornecedor getFornecedor(){
        return this.fornecedor;
    }

    public double getValor(){
        return this.valor;
    }

    public void subtrairEstoque(int quantidade){
        this.estoque -= quantidade;
    }

    public void somarEstoque(int quantidade){
        this.estoque += quantidade;
    }

    public String getTipo(){
        return this.tipo;
    }
    
}