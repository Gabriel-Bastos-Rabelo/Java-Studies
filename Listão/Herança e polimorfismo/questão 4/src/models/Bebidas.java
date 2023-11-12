package models;

public abstract class Bebidas{
    

    private String nome;
    private Fornecedor fornecedor;
    private int estoque;
    private double valor;
    public Bebidas(String nome, Fornecedor fornecedor, int estoque, double valor){
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.estoque = estoque;
        this.valor = valor;

    }

    public String getNome(){
        return this.nome;
    }

    public int getEstoque(){
        return this.estoque;
    }

    public void subtrairEstoque(int quantidade){
        this.estoque -= quantidade;
    }

    public void somarEstoque(int quantidade){
        this.estoque += quantidade;
    }
    
}