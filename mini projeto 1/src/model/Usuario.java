package model;

public class Usuario {
    protected String nome;
    protected String cpf;
    protected int idade;
    protected boolean adulto;
    protected int livrosLidos;
    
    public Usuario(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        if(idade < 18){
            adulto = false;
        }
        else{
            adulto = true;
        }
        this.livrosLidos = 0;
    }


    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public boolean getAdulto(){
        return this.adulto;
    }
    public void setAdulto(boolean adulto){
        this.adulto = adulto;
    }


    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public int getLivrosLidos(){
        return this.livrosLidos;
    }

    public void setLivrosLidos(){
        this.livrosLidos += 1;
    }
}
