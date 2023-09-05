public class App {
    public static void main(String[] args) throws Exception {
        Pizzaria pizzaria = new Pizzaria();
        pizzaria.ReceberPedido("Gabriel", 20);
        pizzaria.ReceberPedido("joao", 20);
        pizzaria.ReceberPedido("dudu", 20);
        pizzaria.ReceberPedido("Pedro", 50);
        pizzaria.PrepararPedido();
        pizzaria.EntregarPedido();

    }
}
