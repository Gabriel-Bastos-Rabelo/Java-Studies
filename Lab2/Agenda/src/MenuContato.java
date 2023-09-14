import java.util.Scanner;

public class MenuContato {

    private Scanner scanner = new Scanner(System.in);
    Contatos contatos = new Contatos();

    public void mostrarMenu() {

        while (true) {

            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                contatos.inserirContato();
            } else if (opcao == 2) {
                contatos.listarContatos();
            } else if (opcao == 3) {
                contatos.pesquisarContato();
            } else if (opcao == 4) {
                break;
            } else {
                System.out.println("Digite uma opção valida");
            }
        }

    }

}
