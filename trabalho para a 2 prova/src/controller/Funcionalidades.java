package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import models.PrecoData;
import models.Produto;

public class Funcionalidades {

    private Hashtable<String, Hashtable<String, Produto>> dados;

    public Funcionalidades(){
        this.dados = new Hashtable<>();

        try{
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("dados.bin"));
            dados = (Hashtable<String, Hashtable<String, Produto>>) entrada.readObject();
            entrada.close();
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
    }

    public void cadastroProduto(String nome, String categoria) {
        if (dados.get(categoria) == null) {
            Hashtable<String, Produto> newHash = new Hashtable<>();
            newHash.put(nome, new Produto(nome));
            dados.put(categoria, newHash);
        } else {
            dados.get(categoria).put(nome, new Produto(nome));
        }

        this.gravar();
    }

    public boolean cadastroNovoPreco(String site, String nome, String categoria, String data, double preco) {
        if (dados.get(categoria) != null) {
            Hashtable<String, Produto> produtos = dados.get(categoria);

            if (produtos.get(nome) != null) {
                produtos.get(nome).novoCadastro(preco, site, data);
                this.gravar();
                return true;
            }

        }

        return false;
    }

    public ArrayList<PrecoData> getHistoricoPrecoSite(String site, String nome, String categoria) {

        if (dados.get(categoria) != null) {
            if (dados.get(categoria).get(nome) != null) {
                ArrayList<PrecoData> newArray = dados.get(categoria).get(nome).getHistoricoPrecoSite(site);
                return newArray;
            }
        }

        return null;
    }

    public void gravar() {
        try{
            ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream("dados.bin"));
            saida.writeObject(dados);
            saida.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }


    public String getMenorPrecoProduto(String categoria, String nome){
        if(dados.get(categoria) != null){
            if(dados.get(categoria).get(nome) != null){
                return dados.get(categoria).get(nome).getMenorPreco();
            }
        }

        return null;
    }

}
