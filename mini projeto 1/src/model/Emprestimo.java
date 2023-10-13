package model;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo extends Movimentacao {
   protected Date dataDevolucao;

    public Emprestimo(Usuario usuario, Date dataMovimentacao, Exemplar exemplar){

        super(usuario, dataMovimentacao, exemplar);

        //TODO colocar limite de devolução

        Calendar calendar = Calendar.getInstance();

        
        calendar.setTime(dataMovimentacao); 

        
        calendar.add(Calendar.DAY_OF_MONTH, 7);

        dataDevolucao = calendar.getTime();

       

                
        


    }


    public Usuario getUsuario(){
        return this.usuario;
    }


    public Exemplar getExemplar(){
        return this.exemplar;
    }

    public Date getDataDevolucao(){
        return this.dataDevolucao;
    }
}
