package models;

public class Venda {
    private Bebidas bebida;
    private int quantidade;


    public Venda(Bebidas bebida, int quantidade){
        this.bebida = bebida;
        this.quantidade = quantidade;
    }
}
