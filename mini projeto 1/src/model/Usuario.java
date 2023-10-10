package model;

public class Usuario {
    protected String nome;
    protected String cpf;
    protected String dataNascimento;
    protected boolean adulto;
    
    public Usuario(String nome, String cpf, String dataNascimento, boolean adulto){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.adulto = adulto;
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

    public void setAdulto(boolean adulto){
        this.adulto = adulto;
    }
}
