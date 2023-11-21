package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Produto implements Serializable{

    private String nome;
    private Hashtable<String, ArrayList<PrecoData>> variacaoPrecoSite;

    public Produto(String nome){
        this.nome = nome;
        variacaoPrecoSite = new Hashtable<>();
    }

    public void novoCadastro(double preco, String site, String data){
        if(variacaoPrecoSite.get(site) == null){
            ArrayList<PrecoData> newArrayPrecos = new ArrayList<>();
            newArrayPrecos.add(new PrecoData(preco, data));
            variacaoPrecoSite.put(site,  newArrayPrecos);
        }
        else{
            variacaoPrecoSite.get(site).add(new PrecoData(preco, data));
        }
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<PrecoData> getHistoricoPrecoSite(String site){
        if(this.variacaoPrecoSite.get(site) != null){
            return this.variacaoPrecoSite.get(site);
        }

        return null;
    }

    public String getMenorPreco(){
        Enumeration<String> e = variacaoPrecoSite.keys();
        double menorPreco = Double.POSITIVE_INFINITY;
        String site = null;
        while(e.hasMoreElements()){
            String key = e.nextElement();

            ArrayList<PrecoData> arrayPrecos = variacaoPrecoSite.get(key);
            if(arrayPrecos.get(arrayPrecos.size() - 1).getPreco() < menorPreco){
                menorPreco = arrayPrecos.get(arrayPrecos.size() - 1).getPreco();
                site = key;
            }


        }

        return "Preço " + menorPreco + " | " + "Site: " + site;
    }

    
}