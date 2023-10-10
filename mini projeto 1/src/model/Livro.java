package model;

public class Livro extends Exemplar{
    protected int exemplar;
    public Livro(String titulo, String autor, int ano, String editora, int qtdPaginas, String genero, int exemplar){
        super(titulo, autor, ano, editora, qtdPaginas, genero);
        this.exemplar = exemplar;
    }
}
