package models;

public class Pessoa{
    private String nome;
    private String CPF;

    public Pessoa(String nome, String CPF){
        this.nome = nome;
        this.CPF = CPF;
    }


    public String getNome(){
        return this.nome;
    }

    public String getCPF(){
        return this.CPF;
    }
}