package view;

import java.util.Scanner;

import controller.Control;
import models.Fornecedor;

public class Menu {
    

    private Scanner scanner;
    private Control funcionalidades;

    public Menu(){
        this.scanner = new Scanner(System.in);
        this.funcionalidades = new Control();
        funcionalidades.inicializarAplicacao();

    }

    public void mostrarMenu(){
        while(true){
            System.out.println("1- Cadastrar bebida");
            System.out.println("2- Inclusão de estoque");
            System.out.println("3- Cadastro de venda");
            System.out.println("4- Cadastrar fornecedor");
            System.out.println("5- Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if(opcao == 5){
                break;
            }

            switch (opcao) {
                case 1:
                    while(true){

                        System.out.println("Digite o tipo de bebida");
                        System.out.println("1- Alcoolica");
                        System.out.println("2- Refrigerante");
                        System.out.println("3- Suco");
                        System.out.println("4- Voltar");
                        int opcaoBebida = scanner.nextInt();
                        scanner.nextLine();
                        if(opcaoBebida == 4){
                            break;
                        }

                        switch (opcaoBebida) {
                            case 1:
                                

                                System.out.println("Digite o nome da bebida");
                                String nomeBebidaAlcoolica = scanner.nextLine();
                                System.out.println("Digite o nome do fornecedor");
                                String fornecedorBebidaAlcoolica = scanner.nextLine();
                                Fornecedor fornecedor = funcionalidades.getFornecedor(fornecedorBebidaAlcoolica);
                                if(fornecedor == null){
                                    System.out.println("Fornecedor não encontrado!");
                                    break;
                                }

                                System.out.println("Digite o estoque da bebida");
                                int estoquebebidaAlcoolica = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Digite o valor da bebida");
                                double valorBebidaAlcoolica = scanner.nextDouble();
                                funcionalidades.cadastrarBebidaAlcoolica(nomeBebidaAlcoolica, fornecedor, estoquebebidaAlcoolica, valorBebidaAlcoolica);

                                break;

                            case 2:
                            
                                System.out.println("Digite o nome da bebida");
                                String nomeBebidaRefrigerante = scanner.nextLine();
                                System.out.println("Digite o nome do fornecedor");
                                String fornecedorBebidadRefrigerante = scanner.nextLine();
                                Fornecedor fornecedorRefri = funcionalidades.getFornecedor(fornecedorBebidadRefrigerante);
                                if(fornecedorRefri == null){
                                    System.out.println("Fornecedor não encontrado!");
                                    break;
                                }

                                System.out.println("Digite o estoque da bebida");
                                int estoquebebidaRefrigerante = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Digite o valor da bebida");
                                double valorBebidaRefrigerante = scanner.nextDouble();
                                funcionalidades.cadastrarBebidaRefrigerante(nomeBebidaRefrigerante, fornecedorRefri, estoquebebidaRefrigerante, valorBebidaRefrigerante);

                                break;

                            case 3:
                                System.out.println("Digite o nome da bebida");
                                String nomeBebidaSuco = scanner.nextLine();
                                System.out.println("Digite o nome do fornecedor");
                                String fornecedorBebidaSuco = scanner.nextLine();
                                Fornecedor fornecedorSuco = funcionalidades.getFornecedor(fornecedorBebidaSuco);
                                if(fornecedorSuco == null){
                                    System.out.println("Fornecedor não encontrado!");
                                    break;
                                }

                                System.out.println("Digite o estoque da bebida");
                                int estoquebebidaSuco = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Digite o valor da bebida");
                                double valorBebidaSuco = scanner.nextDouble();

                                funcionalidades.cadastrarBebidaSuco(nomeBebidaSuco, fornecedorSuco, estoquebebidaSuco, valorBebidaSuco);

                                
                                break;
                        
                            default:
                                System.out.println("Digite uma opção válida!");
                                break;
                        }

                    }
                    break;

                case 2:

                    System.out.println("Digite o nome da bebida");
                    String nomeBebida = scanner.nextLine();
                    System.out.println("Digite a quantidade");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    if(funcionalidades.cadastrarEstoque(nomeBebida, quantidade)){
                        System.out.println("Estoque atualizado com sucesso");
                    }
                    else{
                        System.out.println("Falha ao atualizar o estoque");
                    }

                    break;

                case 3:
                    
                    System.out.println("Digite o nome da bebida");
                    String nomeBebidaVendida = scanner.nextLine();
                    System.out.println("Digite a quantidade");
                    int quantidadeVendida = scanner.nextInt();
                    scanner.nextLine();
                    if(funcionalidades.cadastrarVenda(nomeBebidaVendida, quantidadeVendida)){
                        System.out.println("Venda cadastrada com sucesso");
                    }
                    else{
                        System.out.println("Falha ao cadastrar a venda");
                    }

                    break;

                case 4:
                    System.out.println("Digite o nome do fornecedor");
                    String nomeFornecedor = scanner.nextLine();
                    funcionalidades.cadastroFornecedor(nomeFornecedor);
                    System.out.println("Fornecedor cadastrado com sucesso!");

            
                default:
                    break;
            }




        }
    }
}
