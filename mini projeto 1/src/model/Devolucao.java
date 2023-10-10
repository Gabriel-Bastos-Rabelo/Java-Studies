package model;

public class Devolucao extends Movimentacao{
    
    protected boolean leuObra;

    public Devolucao(Usuario usuario, String dataMovimentacao, Exemplar exemplar, boolean leuObra){
        super(usuario, dataMovimentacao, exemplar);
        this.leuObra = leuObra;
    }
}
