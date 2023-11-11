package models;

import java.time.LocalDate;

public abstract class Atividades implements Comparable<Atividades>{


    protected String descricao;
    protected LocalDate dataEntrega;
    protected String responsavel;
    protected boolean status;


    public Atividades(String descricao, LocalDate dataEntrega, String responsavel, boolean status){
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
        this.status = status;
    }


    @Override
     public String toString(){
         String ret = "";
         ret += "Descrição: ";
         ret += this.descricao;
         ret += "\nData de Entrega: ";
         ret += this.dataEntrega.toString();
         ret += "\nResponsavel: ";
         ret += this.responsavel;
         ret += "\nStatus: ";
         ret += this.status ? "Concluido" : "Não Concluido";

         return ret;
     }


    @Override
    public int compareTo(Atividades at) {


        if (this.dataEntrega.isAfter(at.dataEntrega)){
            return 1;
        } else if (this.dataEntrega.isBefore(at.dataEntrega)) {
            return -1;
        }else {
            return 0;
        }
    }
}