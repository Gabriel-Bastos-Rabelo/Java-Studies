package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Funcionalidades;
import models.*;

public class Menu {
    
    private Scanner scanner;
    Funcionalidades funcionalidades;

    public Menu(){
        scanner = new Scanner(System.in);
        funcionalidades = new Funcionalidades();
    }
    public void MostraMenu(){
        
        while(true){
            System.out.println("Selecione uma das opções abaixo");
            System.out.println("1- Para cadastrar atividade");
            System.out.println("2- Para listar atividades");
            System.out.println("3- Sair");


            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    while(true){
                        System.out.println("1- Cadastrar desenvolvimento");
                        System.out.println("2- Cadastrar Reunião");
                        System.out.println("3- Cadastrar Bug");
                        System.out.println("4- Voltar");

                        int opcaoCadastro = scanner.nextInt();
                        scanner.nextLine();

                        if(opcaoCadastro == 4){
                            break;
                        }

                        switch (opcaoCadastro) {

                            //String descricao, LocalDate dataEntrega, String responsavel, boolean status, String codigo
                            case 1:

                                System.out.println("Digite a descrição:");
                                String descricao = scanner.nextLine();
                                System.out.println("Digite a data de entrega (AAAA-MM-DD)");
                                String dataEntrega = scanner.nextLine();
                                LocalDate dataent = LocalDate.parse(dataEntrega);
                                System.out.println("Digite o nome do responsável");
                                String responsavel = scanner.nextLine();
                                System.out.println("Informe o status: (1 - Concluido | 0 - Nao Concluido)");
                                int statusInt = scanner.nextInt();
                                scanner.nextLine();
                                boolean status = statusInt == 1;
                                System.out.println("Digite o código");
                                String codigo = scanner.nextLine();

                                funcionalidades.CadastrarDesenvolvimento(descricao, dataent, responsavel, status, codigo);
                                System.out.println("Cadastrado com sucesso");
                                

                                
                                break;
                            case 2:
                                System.out.println("Digite a descrição:");
                                String descricaoReuniao = scanner.nextLine();
                                System.out.println("Digite a data de entrega (AAAA-MM-DD)");
                                String dataEntregaReuniao = scanner.nextLine();
                                LocalDate dataentReuniao = LocalDate.parse(dataEntregaReuniao);
                                System.out.println("Digite o nome do responsável");
                                String responsavelReuniao = scanner.nextLine();
                                System.out.println("Informe o status: (1 - Concluido | 0 - Nao Concluido)");
                                int statusIntReuniao = scanner.nextInt();
                                scanner.nextLine();
                                boolean statusReuniao = statusIntReuniao == 1;
                                ArrayList<String> listaParticipantes = new ArrayList<>();

                                int addNew = 1;
                                while(addNew != 0){
                                    System.out.println("Informe o participante:");
                                    String p = scanner.nextLine();
                                    listaParticipantes.add(p);
                                    System.out.println("Adicionar novo participante? (1 - Sim | 0 - Nao)");
                                    addNew = scanner.nextInt();
                                    scanner.nextLine();
                                }


                                funcionalidades.CadastrarReuniao(descricaoReuniao, dataentReuniao, responsavelReuniao, statusReuniao, listaParticipantes);
                                System.out.println("Reunião cadastrada com sucesso");


                                break;
                            case 3:

                                System.out.println("Digite a descrição:");
                                String descricaoBug = scanner.nextLine();
                                System.out.println("Digite a data de entrega (AAAA-MM-DD)");
                                String dataEntregaBug = scanner.nextLine();
                                LocalDate dataentBug = LocalDate.parse(dataEntregaBug);
                                System.out.println("Digite o nome do responsável");
                                String responsavelBug = scanner.nextLine();
                                System.out.println("Informe o status: (1 - Concluido | 0 - Nao Concluido)");
                                int statusIntBug = scanner.nextInt();
                                scanner.nextLine();
                                boolean statusBug = statusIntBug == 1;
                                System.out.println("Informe o local do bug");
                                String localBug = scanner.nextLine();

                                funcionalidades.CadastrarBug(descricaoBug, dataentBug, responsavelBug, statusBug, localBug);
                                System.out.println("Reportage de bug cadastrada com sucesso!");
                                
                                break;
                        
                            default:
                                System.out.println("Selecione uma opção válida!");
                                break;
                        }

                    }
                    break;
                case 2:
                    ArrayList<Atividades> listaAtividades = funcionalidades.getListaAtividades();

                    for(Atividades a : listaAtividades){
                        System.out.println(a.toString());
                    }

                    break;
            
                default:
                    System.out.println("Digite um opção válida");
                    break;
            }
        }
    }
}
