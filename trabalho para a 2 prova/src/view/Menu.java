package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Funcionalidades;
import models.*;

public class Menu {
    private Scanner scanner;
    private Funcionalidades funcionalidades;

    public Menu(){
        this.scanner = new Scanner(System.in);
        this.funcionalidades = new Funcionalidades();
    }

    public void mostraMenu(){
        while(true){
            System.out.println("1- Cadastrar novo produto");
            System.out.println("2- Cadastrar preço de produto");
            System.out.println("3- Mostra histórico de preços de um produto em um site");
            System.out.println("4- Buscar menor preço para um produto");
            System.out.println("5- Sair");


            int opcao = scanner.nextInt();
            if(opcao == 5){
                break;
            }
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Digite a categoria do produto");
                    String categoria = scanner.nextLine();
                    System.out.println("Digite o nome do produto");
                    String nome = scanner.nextLine();
                    funcionalidades.cadastroProduto(nome, categoria);
                    break;
                    

                case 2:
                    System.out.println("Digite a categoria do produto");
                    String categoriaNovoPreco = scanner.nextLine();
                    System.out.println("Digite o nome do produto");
                    String nomeNovoPreco = scanner.nextLine();
                    System.out.println("Digite o valor do produto");
                    Double preco = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite o site do produto");
                    String site = scanner.nextLine();
                    System.out.println("Digite a data");
                    String data = scanner.nextLine();
                    funcionalidades.cadastroNovoPreco(site, nomeNovoPreco, categoriaNovoPreco, data, preco);
                    break;

                case 3:
                    System.out.println("Digite a categoria do produto");
                    String categoriaBuscar = scanner.nextLine();
                    System.out.println("Digite o nome do produto");
                    String nomeBuscar = scanner.nextLine();
                    System.out.println("Digite o nome do site");
                    String siteBuscar = scanner.nextLine();

                    ArrayList<PrecoData> arrayPrecoData = funcionalidades.getHistoricoPrecoSite(siteBuscar, nomeBuscar, categoriaBuscar);

                    for(PrecoData p: arrayPrecoData){
                        System.out.println(p.toString());
                    }


                    break;

                case 4:

                    System.out.println("Digite a categoria do produto");
                    String menorPrecoCategoria = scanner.nextLine();
                    System.out.println("Digite o nome do produto");
                    String menorPrecoNome = scanner.nextLine();

                    System.out.println(funcionalidades.getMenorPrecoProduto(menorPrecoCategoria, menorPrecoNome));

                    break;
                    
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        }
    }
}
