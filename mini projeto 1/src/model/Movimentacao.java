package model;

public abstract class Movimentacao {
    protected Usuario usuario;
    protected String dataMovimentacao;
    protected Exemplar exemplar;

    public Movimentacao(Usuario usuario, String dataMovimentacao, Exemplar exemplar){
        this.usuario = usuario;
        this.dataMovimentacao = dataMovimentacao;
        this.exemplar = exemplar;
    }


} 