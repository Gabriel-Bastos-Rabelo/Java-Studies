import java.util.ArrayList;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.plaf.synth.SynthSliderUI;

import controller.Funcionalidades;
import model.Building;
import model.Car;
import model.CarbonFootPrint;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        Funcionalidades funcionalidades = new Funcionalidades();
        while(true){
            System.out.println("Digite 1 para adicionar um carro");
            System.out.println("Digite 2 para adicionar uma bicicleta");
            System.out.println("Digite 3 para adicionar um prédio");
            System.out.println("Digite 4 para mostrar a pegada de carbono");
            System.out.println("Digite 5 para sair.");

            int opcao = entrada.nextInt();
            entrada.nextLine();

            if(opcao == 5){
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite a kilometragem percorrida com o carro");
                    int km = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Digite por quantos minutos foi usado");
                    int minutosCarro = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Digite o tipo de combustível que foi usado");
                    String combustivelCarro = entrada.nextLine();

                    if(km > 0 && minutosCarro > 0){
                        funcionalidades.adicionarCarro(km, combustivelCarro, minutosCarro);
                    }
                    else{
                        System.out.println("Erro, a kilometragem e os minutos tem que ser maior que 0");
                    }
                    break;
                case 2:
                    System.out.println("Digite por quantos minutos foi usada");
                    int minutosBike = entrada.nextInt();
                    entrada.nextLine();
                    if(minutosBike > 0){
                        funcionalidades.adicionarBicicleta(minutosBike);
                    }
                    else{
                        System.out.println("Erro, a kilometragem tem que ser maior que 0");
                    }
                    break;
                case 3:
                    System.out.println("Digite a área do prédio");
                    double area = entrada.nextDouble();
                    entrada.nextLine();

                    System.out.println("Digite o tipo de combustível utilizado");
                    String combustivel = entrada.nextLine();

                    System.out.println("Digite por quantas horas é usado");

                    int horasBuilding = entrada.nextInt();
                    entrada.nextLine();
                    if(area > 0 && horasBuilding > 0){
                        funcionalidades.adicionarBulding(area, combustivel, horasBuilding);
                    }
                    else{
                        System.out.println("Erro, a área e as horas tem que ser maior que 0");
                    }
                    break;
                case 4:

                    ArrayList<CarbonFootPrint> carbonFootPrintList = funcionalidades.getPegadaCarbono();
                    for(CarbonFootPrint pegada: carbonFootPrintList){
                        if(pegada instanceof Car){
                            System.out.println("Carro: ");
                        }
                        else if(pegada instanceof Building){
                            System.out.println("Construção: ");
                        }
                        else{
                            System.out.println("Bicicleta: ");
                        }
                        System.out.println("A pegada de carbono é de " + pegada.getCarbonFootPrint());
                    }
                    break;
                
            
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
           
        }
    }
}
