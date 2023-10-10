package model;

public class Revista  extends Exemplar{
    protected int volume;
    protected int mesPublicacao;
    public Revista(String titulo, String autor, int ano, String editora, int qtdPaginas, String genero, int volume, int mesPublicacao){
        super(titulo, autor, ano, editora, qtdPaginas, genero);
        this.volume = volume;
        this.mesPublicacao = mesPublicacao;
    }
}
