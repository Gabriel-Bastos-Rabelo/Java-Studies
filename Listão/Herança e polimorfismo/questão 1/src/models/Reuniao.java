package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reuniao extends Atividades{

    private ArrayList<String> listaParticipantes;


    public Reuniao(String descricao, LocalDate dataEntrega, String responsavel, boolean status, ArrayList<String> listaParticipantes){
        super(descricao, dataEntrega, responsavel, status);
        this.listaParticipantes = listaParticipantes;
    }


    @Override
    public String toString() {
        String ret =  super.toString();
        ret += "\nParticipantes: \n";
        for (String p: this.listaParticipantes) {
            ret += p;
            ret += "\n";
        }
        return ret;
    }
}
