package view;

import java.util.Scanner;

public class Menu {
    protected Scanner entrada;
    public Menu(){

        entrada = new Scanner(System.in);

    }

    public void exibirMenu(){

    
            System.out.println("    MENU    ");
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1. Cadastrar acervo");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Consultar acervo");
            System.out.println("4. Realizar Empréstimo");
            System.out.println("5. Situação empréstimo");
            System.out.println("6. Realizar devolução");
            System.out.println("5. Emitir relatório empréstimo/devolução");
            System.out.println("7. Emitir ranking de leitura");
            System.out.println("8. Sair");



    }


    public void escolherFuncao(){
        while(true){
            exibirMenu();
            int opcao = entrada.nextInt();
            entrada.nextLine();

            if(opcao > 8 || opcao < 1){
                System.out.println("Escolha uma opção válida");
                continue;
            }
            else if(opcao == 8){
                break;
            }
            
        }
    }
}
