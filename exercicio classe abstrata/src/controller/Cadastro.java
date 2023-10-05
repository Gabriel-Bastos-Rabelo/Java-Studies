package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cadastro {
    
    protected ArrayList<AtividadeFisica> listaAtividades;


    public Cadastro(){
        listaAtividades = new ArrayList<AtividadeFisica>();
    }

    public void cadastrarCaminhada(int tempo, LocalDate data, int calorias, int ritmo, int trajeto){

        Caminhada novaCaminhada = new Caminhada(tempo, data, calorias, ritmo, trajeto);
        listaAtividades.add(novaCaminhada);
    }


    public void cadastrarNatacao(int tempo, LocalDate data, int calorias, int volta, int metragem){
        Natacao novaNatacao = new Natacao(tempo, data, calorias, volta, metragem);
        listaAtividades.add(novaNatacao);
    }


    public void cadastrarMusculacao(int tempo, LocalDate data, int calorias, int carga, int repeticoes){
        Musculacao novaMusculacao = new Musculacao(tempo, data, calorias, carga, repeticoes);
        listaAtividades.add(novaMusculacao);
    }


    public ArrayList<AtividadeFisica> getListaAtividadeFisicas(){
        return listaAtividades;
    }
}
