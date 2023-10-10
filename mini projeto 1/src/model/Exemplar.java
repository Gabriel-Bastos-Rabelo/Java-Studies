package model;

public abstract class Exemplar{
    protected String titulo;
    protected String autor;
    protected int ano;
    protected String resumo;
    protected String editora;
    protected int qtdPaginas;
    protected String genero;
    protected boolean disponivel;
    public Exemplar(String titulo, String autor, int ano, String editora, int qtdPaginas, String genero){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
        this.genero = genero;
        this.disponivel = true;
    }


    public boolean getDisponivel(){
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
}