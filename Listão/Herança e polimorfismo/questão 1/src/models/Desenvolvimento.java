package models;

import java.time.LocalDate;

public class Desenvolvimento extends Atividades {
    

    private String codigo;

    public Desenvolvimento(String descricao, LocalDate dataEntrega, String responsavel, boolean status, String codigo){
        super(descricao, dataEntrega, responsavel, status);
        this.codigo = codigo;
    }


    @Override
    public String toString() {
        String ret = super.toString();
        ret += "\nCodigo: \n";
        ret += this.codigo;

        return ret;
    }


}
