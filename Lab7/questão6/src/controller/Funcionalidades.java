package controller;

import java.util.ArrayList;
import java.util.Enumeration;
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

    public ArrayList<Pessoa> buscarFamilia(String sobrenome, Hashtable<String, ArrayList<Pessoa>> hashtable){
        if(hashtable != null){
            ArrayList<Pessoa> listaFamilia = hashtable.get(sobrenome);

            return listaFamilia;
        }

        return null;
    }


    public ArrayList<String> buscarPrimeiroNome(String nome, Hashtable<String, ArrayList<Pessoa>> hashtable){
        if(hashtable != null){
            ArrayList<String> listaNomes = new ArrayList<>();
            Enumeration<String> e = hashtable.keys();

            while(e.hasMoreElements()){
                String key = e.nextElement();

                ArrayList<Pessoa> listaFamilia = hashtable.get(key);

                for(Pessoa p: listaFamilia){
                    if(p.getNome().equals(nome)){
                        listaNomes.add(p.getNome() + " " + key);
                    }
                }
            }


            return listaNomes;
        }

        return null;
    }


    
}
