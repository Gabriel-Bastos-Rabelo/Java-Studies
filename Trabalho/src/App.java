public class App {
    public static void main(String[] args) throws Exception {
        Presenter presenter = new Presenter();

        presenter.cadastroAdministrador("08407161179", "gabriel bastos rabelo", 10000, "administração", 5000);
        presenter.cadastroAdministrador("08407161179", "gabriel bastos rabelo", 10000, "administração", 5000);
        presenter.cadastroAdministrador("08407161179", "gabriel bastos rabelo", 10000, "administração", 5000);
        float total = presenter.folhaPagamento();

        System.out.println(total);

    }
}
