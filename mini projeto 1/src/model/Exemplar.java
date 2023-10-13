package model;

public abstract class Exemplar{
    protected String titulo;
    protected String autor;
    protected int ano;
    protected String resumo;
    protected String editora;
    protected int qtdPaginas;
    protected String genero;
    protected boolean statusDisponivel;
    public Exemplar(String titulo, String autor, int ano, String editora, int qtdPaginas, String genero){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
        this.genero = genero;
        this.statusDisponivel = true;
    }


    public boolean getDisponivel(){
        return this.statusDisponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.statusDisponivel = disponivel;
    }


    public String getTitulo(){
        return this.titulo;
    }


    public String getAutor(){
        return this.autor;
    }
}