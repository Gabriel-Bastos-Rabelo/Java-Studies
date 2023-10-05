package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estatistica {
    
    protected Cadastro cadastro;
    protected ArrayList<AtividadeFisica> listaAtividades;


    public Estatistica(Cadastro cadastro){
        this.cadastro = cadastro;
        listaAtividades = cadastro.getListaAtividadeFisicas();
    }

    public ArrayList<AtividadeFisica> getAtividadesDoDia(){
        
        
        ArrayList<AtividadeFisica> atividadesHoje = new ArrayList<AtividadeFisica>();
        LocalDate hoje = LocalDate.now();
        for(AtividadeFisica atividade : listaAtividades){
            LocalDate data = atividade.getData();
            if(data.equals(hoje)){
                atividadesHoje.add(atividade);
            }
        }


        return atividadesHoje;

    }

    public int volumeSemana(){
        int tempo = 0;
        for(AtividadeFisica atividade : listaAtividades){
            tempo += atividade.getTempo();
        }


        return tempo;
    }


    public int volumeCalorias(){
        int calorias = 0;
        for(AtividadeFisica atividade : listaAtividades){
            calorias += atividade.calcularCalorias();
        }

        return calorias;
    }


}
