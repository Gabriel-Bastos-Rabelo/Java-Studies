package view;


import controller.*;

public class App {
    public static void main(String[] args) throws Exception {
        Cadastro cadastro = new Cadastro();
        Estatistica estatistica = new Estatistica(cadastro);
        Menu menu = new Menu(estatistica, cadastro);
        menu.exibirMenu();

    }
}
