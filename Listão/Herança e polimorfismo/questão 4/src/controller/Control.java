package controller;

import java.util.ArrayList;

import models.Alcoolicas;
import models.Bebidas;
import models.Fornecedor;
import models.Refrigerante;
import models.Suco;
import models.Venda;

public class Control {
    

    private ArrayList<Bebidas> listaBebidas;
    private ArrayList<Fornecedor> listaFornecedores;
    private ArrayList<Venda> listaVendas;

    public Control(){
        this.listaBebidas = new ArrayList<>();
        this.listaFornecedores = new ArrayList<>();
        this.listaVendas = new ArrayList<>();
    }

    public void cadastrarBebidaAlcoolica(String nome, Fornecedor fornecedor, int estoque, double valor){
        listaBebidas.add(new Alcoolicas(nome, fornecedor, estoque, valor));
    }

    public void cadastrarBebidaSuco(String nome, Fornecedor fornecedor, int estoque, double valor){
        listaBebidas.add(new Suco(nome, fornecedor, estoque, valor));
    }

    public void cadastrarBebidaRefrigerante(String nome, Fornecedor fornecedor, int estoque, double valor){
        listaBebidas.add(new Refrigerante(nome, fornecedor, estoque, valor));
    }

    public void cadastroFornecedor(String nome){
        listaFornecedores.add(new Fornecedor(nome));
    }

    public Fornecedor getFornecedor(String nome){
        for(Fornecedor f : listaFornecedores){
            if(f.getNome().equals(nome)){
                return f;
            }
        }

        return null;
    }

    public boolean cadastrarVenda(String bebida, int quantidade){
        for(Bebidas b: listaBebidas){
            if(b.getNome().equals(bebida)){
                if(quantidade <= b.getEstoque()){
                    b.subtrairEstoque(quantidade);
                    listaVendas.add(new Venda(b, quantidade));

                    return true;
                }

            }
        }

        return false;
    }

    public boolean cadastrarEstoque(String bebida, int quantidade){
         for(Bebidas b: listaBebidas){
            if(b.getNome().equals(bebida)){
                b.somarEstoque(quantidade);
                return true;

            }
        }

        return false;
    }


    
}
