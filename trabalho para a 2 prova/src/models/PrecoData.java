package models;

import java.io.Serializable;

public class PrecoData implements Serializable {


    private double preco;
    private String data;


    public PrecoData(double preco, String data){
        this.preco = preco;
        this.data = data;
    }


    public double getPreco(){
        return this.preco;
    }

    public String getData(){
        return this.data;
    }


    public String toString(){
        return this.data + " | " + this.preco;
    }
}
