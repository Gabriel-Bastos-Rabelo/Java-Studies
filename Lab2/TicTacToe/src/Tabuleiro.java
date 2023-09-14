package src;

import java.util.Scanner;

public class Tabuleiro {
    private String tabuleiro[][];
    private int numeroJogadas;
    Menu menu = new Menu();

    public Tabuleiro() {
        tabuleiro = new String[3][3];
        numeroJogadas = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = "E";
            }
        }
    }

    public void iniciarJogo() {

        Scanner scanner = new Scanner(System.in);
        String simbolo;

        while (true) {
            System.out.println("Qual o símbolo do primeiro jogador? (X ou O)");
            String entrada = scanner.nextLine();
            if (!entrada.equals("O") && !entrada.equals("X")) {
                System.out.println("A entrada deve ser ou X ou O");
            } else {
                simbolo = entrada;
                break;
            }

        }

        while (true) {

            System.out.println("Escolha uma linha e um coluna: ");
            String entrada = scanner.nextLine();
            String[] elementos = entrada.split(" ");

            if (numeroJogadas == 9) {
                System.out.println("O jogo terminou empatado");
                break;
            }

            if (jogada(simbolo, Integer.parseInt(elementos[0]), Integer.parseInt(elementos[1]))) {
                System.out.println("O jogo acabou");
                break;
            }

            numeroJogadas += 1;

            if (simbolo.equals("X")) {
                simbolo = "O";
            } else {
                simbolo = "X";
            }

        }

    }

    public boolean jogada(String simbolo, int posX, int posY) {
        if (!this.tabuleiro[posX][posY].equals("E")) {
            System.out.println("Essa posição já está ocupada");

        } else if (!simbolo.equals("O") && !simbolo.equals("X")) {
            System.out.println("Insira um simbolo que exista");

        } else {
            tabuleiro[posX][posY] = simbolo;
            boolean venceu = verificarVencedor();
            if (venceu == true) {
                this.menu.exibirMenu(tabuleiro);
                return true;
            }
        }

        this.menu.exibirMenu(tabuleiro);

        return false;
    }

    public boolean verificarVencedor() {

        if ((!tabuleiro[0][0].equals("E") && tabuleiro[0][0].equals(tabuleiro[0][1])
                && tabuleiro[0][1].equals(tabuleiro[0][2])) ||
                (!tabuleiro[1][0].equals("E") && tabuleiro[1][0].equals(tabuleiro[1][1])
                        && tabuleiro[1][1].equals(tabuleiro[1][2]))
                ||
                (!tabuleiro[2][0].equals("E") && tabuleiro[2][0].equals(tabuleiro[2][1])
                        && tabuleiro[2][1].equals(tabuleiro[2][2]))) {

            return true;

        }

        else if ((!tabuleiro[0][0].equals("E") && tabuleiro[0][0].equals(tabuleiro[1][0])
                && tabuleiro[1][0].equals(tabuleiro[2][0])) ||
                (!tabuleiro[0][1].equals("E") && tabuleiro[0][1].equals(tabuleiro[1][1])
                        && tabuleiro[1][1].equals(tabuleiro[2][1]))
                ||
                (!tabuleiro[0][2].equals("E") && tabuleiro[0][2].equals(tabuleiro[1][2])
                        && tabuleiro[1][2].equals(tabuleiro[2][2]))) {

            return true;
        }

        else if ((!tabuleiro[0][0].equals("E") && tabuleiro[1][1].equals(tabuleiro[0][0])
                && tabuleiro[1][1].equals(tabuleiro[2][2])) ||
                (!tabuleiro[0][2].equals("E") && tabuleiro[0][2].equals(tabuleiro[1][1])
                        && tabuleiro[1][1].equals(tabuleiro[2][0]))) {

            return true;
        }

        return false;

    }

}