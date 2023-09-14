import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private HeartRates heartRates;
    int dinheiro;

    public Menu(HeartRates heartRates) {
        this.heartRates = heartRates;
    }

    public void mostrarMenu() {
        while (true) {

            System.out.println(
                    "Escolha uma opção abaixo\n 1. Idade\n 2. Consultar frequência cardíaca máxima\n 3. Consultar frequência cardíaca alvo\n 4. Sair");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println(heartRates.getIdade());
            } else if (opcao == 2) {
                System.out.println(heartRates.getFreqMax());
            } else if (opcao == 3) {
                System.out.println(heartRates.getFreqAlvo());
            } else if (opcao == 4) {
                break;
            } else {
                System.out.println("Digite uma opção válida");
            }

        }

    }

}
