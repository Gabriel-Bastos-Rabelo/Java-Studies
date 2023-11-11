package models;

import java.time.LocalDate;

public class Bug extends Atividades{

    private String local;

    public Bug(String descricao, LocalDate dataEntrega, String responsavel, boolean status, String local){
        super(descricao, dataEntrega, responsavel, status);
        this.local = local;

    }

    @Override
    public String toString() {
        String ret = super.toString();
        ret += "\nLocal: ";
        ret += this.local;

        return ret;
    }

   
    }

    
