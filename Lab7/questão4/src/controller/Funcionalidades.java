package controller;

import java.util.ArrayList;
import java.util.Hashtable;

import models.Pessoa;

public class Funcionalidades {
    

    public void inserirNoHash(Hashtable<String, ArrayList<Pessoa>> hashtable, String sobrenome, Pessoa pessoa){
        if(hashtable != null){
            if(hashtable.get(sobrenome) != null){
                hashtable.get(sobrenome).add(pessoa);
            }
            else{
                ArrayList<Pessoa> familia = new ArrayList<>();
                familia.add(pessoa);
                hashtable.put(sobrenome, familia);
            }
        }
    }
}
