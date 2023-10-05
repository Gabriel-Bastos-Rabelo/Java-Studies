package view;

import java.util.Scanner;

import controller.*;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;;

public class Menu {
    protected Scanner entrada;
    protected Estatistica estatistica;
    protected Cadastro cadastro;

    public Menu(Estatistica estatistica, Cadastro cadastro) {
        entrada = new Scanner(System.in);
        this.estatistica = estatistica;
        this.cadastro = cadastro;
    }

    public void exibirMenu() {

        while (true) {
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1. Cadastro de atividades físicas");
            System.out.println("2. Exibir todas as atividades do dia");
            System.out.println("3. Exibir tempo gasto na semana");
            System.out.println("4. Exibir calorias gastas na semana");
            System.out.println("5. Sair");
            int opcao = entrada.nextInt();
            entrada.nextLine();
            if (opcao < 1 || opcao > 5) {
                System.out.println("Escolha uma opção válida");
                continue;
            }
            if (opcao == 5) {
                System.out.println("Finalizando...");
                break;
            }

            switch (opcao) {
                case 1:
                    exibirMenuAtividades();
                    break;
                case 2:
                    ArrayList<AtividadeFisica> listaAtividades = estatistica.getAtividadesDoDia();
                    for (AtividadeFisica atividade : listaAtividades) {
                        if (atividade instanceof Caminhada) {
                            System.out.println("Caminhada | Duração: " + atividade.getTempo() + " | Data: "
                                    + atividade.getData() + " | Calorias: " + atividade.calcularCalorias() + " | Ritmo: "
                                    + ((Caminhada) atividade).getRitmo() + " | Trajeto: "
                                    + ((Caminhada) atividade).getTrajeto());
                        } else if (atividade instanceof Musculacao) {
                            System.out.println("Musculação | Duração: " + atividade.getTempo() + " | Data: "
                                    + atividade.getData() + " | Calorias: " + atividade.calcularCalorias()
                                    + " | Carga: " + ((Musculacao) atividade).getCarga() + " | Repetições: "
                                    + ((Musculacao) atividade).getRepeticoes());
                        } else {
                            System.out.println("Natação | Duração: " + atividade.getTempo() + " | Data: "
                                    + atividade.getData() + " | Calorias: " + atividade.calcularCalorias()
                                    + " | Voltas: " + ((Natacao) atividade).getVoltas() + " | Metragem: "
                                    + ((Natacao) atividade).getMetragem());
                        }
                    }
                    break;
                case 3:
                    int tempoSemana = estatistica.volumeSemana();
                    System.out.println("O tempo gasto na semana foi de " + tempoSemana + " minutos");
                    break;
                case 4:
                    int caloriasSemana = estatistica.volumeCalorias();
                    System.out.println("Você gastou " + caloriasSemana + " calorias na semana");
                    break;

                default:
                    System.out.println("Opção não reconhecida.");
            }

        }
    }

    public void exibirMenuAtividades() {
        while (true) {
            System.out.println("Escolha uma opção de atividade abaixo:");
            System.out.println("1. Caminhada");
            System.out.println("2. Musculação");
            System.out.println("3. Natação");
            System.out.println("4. Voltar");
            int opcao = entrada.nextInt();
            entrada.nextLine();
            if (opcao < 1 || opcao > 4) {
                System.out.println("Escolha uma opção válida");
                continue;
            }
            if (opcao == 4) {
                break;
            }

            System.out.println("Digite a duração da atividade:");
            int tempo = entrada.nextInt();
            entrada.nextLine();
            LocalDate data = LocalDate.now();
            System.out.println("Digite as calorias gastas na atividade:");
            int calorias = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Digite o ritmo da atividade:");
                    int ritmo = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Digite o trajeto da atividade:");
                    int trajeto = entrada.nextInt();
                    entrada.nextLine();
                    cadastro.cadastrarCaminhada(tempo, data, calorias, ritmo, trajeto);
                    break;
                case 2:
                    System.out.println("Digite a carga");
                    int carga = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Digite o número de repetições");
                    int repeticoes = entrada.nextInt();
                    entrada.nextLine();
                    cadastro.cadastrarMusculacao(tempo, data, calorias, carga, repeticoes);
                    break;
                case 3:
                    System.out.println("Digite o número de voltas");
                    int voltas = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Digite a metragem");
                    int metragem = entrada.nextInt();
                    entrada.nextLine();
                    cadastro.cadastrarNatacao(tempo, data, calorias, voltas, metragem);
                    break;

                default:
                    System.out.println("Opção não reconhecida.");
            }
        }
    }
}
