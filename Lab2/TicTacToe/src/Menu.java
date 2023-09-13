package src;

public class Menu {
    public void exibirMenu(String matriz[][]) {

        System.out.println("Selecione uma posição que esteja vazia");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }
}
