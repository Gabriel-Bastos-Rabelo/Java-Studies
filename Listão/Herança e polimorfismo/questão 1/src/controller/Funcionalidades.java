package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import models.Atividades;
import models.Bug;
import models.Desenvolvimento;
import models.Reuniao;

public class Funcionalidades {

    private ArrayList<Atividades> listaAtividades;

    public Funcionalidades(){
        this.listaAtividades = new ArrayList<>();
    }
    

    public void CadastrarDesenvolvimento(String descricao, LocalDate dataEntrega, String responsavel, boolean status, String codigo){
        Desenvolvimento newDesenvolvimento = new Desenvolvimento(descricao, dataEntrega, responsavel, status, codigo);
        listaAtividades.add(newDesenvolvimento);
                
        
    }

    public void CadastrarReuniao(String descricao, LocalDate dataEntrega, String responsavel, boolean status, ArrayList<String> listaParticipantes){
        Reuniao newReuniao = new Reuniao(descricao, dataEntrega, responsavel, status, listaParticipantes);
        listaAtividades.add(newReuniao);
    }


    public void CadastrarBug(String descricao, LocalDate dataEntrega, String responsavel, boolean status, String local){
        Bug newBug = new Bug(descricao, dataEntrega, responsavel, status, local);
        listaAtividades.add(newBug);
    }

    public ArrayList<Atividades> getListaAtividades(){
        Collections.sort(listaAtividades);
        return this.listaAtividades;
    }


}
