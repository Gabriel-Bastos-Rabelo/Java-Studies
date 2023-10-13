package model;
import java.util.Date;
public class Devolucao extends Movimentacao{
    
    protected boolean leuObra;

    public Devolucao(Usuario usuario, Date dataMovimentacao, Exemplar exemplar, boolean leuObra){
        super(usuario, dataMovimentacao, exemplar);
        this.leuObra = leuObra;
    }
}
