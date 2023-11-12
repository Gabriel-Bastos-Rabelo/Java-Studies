package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public Control() {
        this.listaBebidas = new ArrayList<>();
        this.listaFornecedores = new ArrayList<>();
        this.listaVendas = new ArrayList<>();
    }

    public void inicializarAplicacao(){
    
        this.inicializarListaFornecedores();
        this.inicializarListaBebidas();
    }

    public void inicializarListaFornecedores(){
        File arquivo = new File("./fornecedores.txt");

        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader bf = new BufferedReader(fr);
            while(bf.ready()){
                String linha = bf.readLine();
                System.out.println(linha);
                Fornecedor newFornecedor  = new Fornecedor(linha);
                listaFornecedores.add(newFornecedor);
            }

            bf.close();
            fr.close();



        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void inicializarListaBebidas(){
        File arquivo = new File("./bebidas.txt");


        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            String[] parametros = new String[5];
            while(br.ready()){
                String linha = br.readLine();
                String current = "";
                int j = 0;
                for(int i = 0; i < linha.length(); i++){
                    if(linha.charAt(i) == ';'){
                        parametros[j] = current;
                        j += 1;
                        current = "";
                    }
                    else{
                        current += linha.charAt(i);
                    }
                    
                }

                
                System.out.println(parametros[0] + " " + parametros[1] + " " + parametros[2] + " " + parametros[3] + " " + parametros[4]);
                if(parametros[0].equals("Alcoolica")){
                    Alcoolicas newBebida = new Alcoolicas(parametros[1], this.getFornecedor(parametros[2]), Integer.parseInt(parametros[3]), Double.parseDouble(parametros[4]), parametros[0]);
                    listaBebidas.add(newBebida);
                }
                else if(parametros[0].equals("Refrigerante")){
                    Refrigerante newBebida = new Refrigerante(parametros[1], this.getFornecedor(parametros[2]), Integer.parseInt(parametros[3]), Double.parseDouble(parametros[4]), parametros[0]);
                    listaBebidas.add(newBebida);
                }
                else{
                    Suco newBebida = new Suco(parametros[1], this.getFornecedor(parametros[2]), Integer.parseInt(parametros[3]), Double.parseDouble(parametros[4]), parametros[0]);
                    listaBebidas.add(newBebida);
                }
               

            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void cadastrarBebidaAlcoolica(String nome, Fornecedor fornecedor, int estoque, double valor) {
        listaBebidas.add(new Alcoolicas(nome, fornecedor, estoque, valor, "Alcoolica"));
        this.atualizarArquivoBebidas(nome, fornecedor.getNome(), estoque, valor);
    }

    public void cadastrarBebidaSuco(String nome, Fornecedor fornecedor, int estoque, double valor) {
        listaBebidas.add(new Suco(nome, fornecedor, estoque, valor, "Suco"));
        this.atualizarArquivoBebidas(nome, fornecedor.getNome(), estoque, valor);
    }

    public void cadastrarBebidaRefrigerante(String nome, Fornecedor fornecedor, int estoque, double valor) {
        listaBebidas.add(new Refrigerante(nome, fornecedor, estoque, valor, "Refrigerante"));
        this.atualizarArquivoBebidas(nome, fornecedor.getNome(), estoque, valor);
    }

    public void atualizarArquivoBebidas(String nome, String fornecedor, int estoque, double valor) {
        File arquivo = new File("./bebidas.txt");

        try{

            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for(Bebidas b: listaBebidas){
                bw.write(b.getTipo() + ";" + b.getNome() + ";" + b.getFornecedor().getNome() + ";" + b.getEstoque() + ";" + b.getValor()  + ";" + "\n");
            }

            bw.close();
            fw.close();


        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        

        
    }

    public void cadastroFornecedor(String nome) {
        listaFornecedores.add(new Fornecedor(nome));
        File arquivo = new File("./fornecedores.txt");
        try {
            FileWriter fw = new FileWriter(arquivo, true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(nome + "\n");

            bw.close();
            fw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

    public Fornecedor getFornecedor(String nome) {
        for (Fornecedor f : listaFornecedores) {
            if (f.getNome().equals(nome)) {
                return f;
            }
        }

        return null;
    }

    public boolean cadastrarVenda(String bebida, int quantidade) {
        for (Bebidas b : listaBebidas) {
            if (b.getNome().equals(bebida)) {
                if (quantidade <= b.getEstoque()) {
                    b.subtrairEstoque(quantidade);
                    listaVendas.add(new Venda(b, quantidade));
                    this.atualizarArquivoBebidas(b.getNome(), b.getFornecedor().getNome(), b.getEstoque(), b.getValor());
                    File arquivo = new File("./vendas.txt");

                    try {
                        FileWriter fw = new FileWriter(arquivo, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(bebida + ";" + quantidade + "\n");

                        bw.close();
                        fw.close();

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    return true;
                }

            }
        }

        return false;
    }

    public boolean cadastrarEstoque(String bebida, int quantidade) {
        for (Bebidas b : listaBebidas) {
            if (b.getNome().equals(bebida)) {
                b.somarEstoque(quantidade);
                this.atualizarArquivoBebidas(b.getNome(), b.getFornecedor().getNome(), b.getEstoque(), b.getValor());
                return true;

            }
        }

        return false;
    }

}
