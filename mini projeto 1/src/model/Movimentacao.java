package model;

import java.util.Date;

public abstract class Movimentacao {
    protected Usuario usuario;
    protected Date dataMovimentacao;
    protected Exemplar exemplar;

    public Movimentacao(Usuario usuario, Date dataMovimentacao, Exemplar exemplar){
        this.usuario = usuario;
        this.dataMovimentacao = dataMovimentacao;
        this.exemplar = exemplar;
    }


    public Exemplar getExemplar(){
        return this.exemplar;
    }


    public Usuario getUsuario(){
        return this.usuario;
    }

    public Date getDataMovimentacao(){
        return this.dataMovimentacao;
    }


} 