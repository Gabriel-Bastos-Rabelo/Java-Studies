package model;

public class Usuario {
    protected String nome;
    protected String cpf;
    protected String dataNascimento;
    protected boolean adulto;
    protected int livrosLidos;
    
    public Usuario(String nome, String cpf, String dataNascimento, boolean adulto){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.adulto = adulto;
        this.livrosLidos = 0;
    }


    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
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
