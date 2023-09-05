import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pizzaria {
    private float caixa = 0;
    Map<String, Float> dicionario = new LinkedHashMap<>();

    public void ReceberPedido(String name, float valor) {
        Cliente cliente = new Cliente(name, valor);
        this.dicionario.put(cliente.getName(), cliente.getValor());

    }

    public void PrepararPedido() {

        for (String chave : dicionario.keySet()) {
            this.caixa += dicionario.get(chave);
            System.out.println("Pedido recebido do cliente " + chave);

        }

        System.out.println("Valor total do caixa eh " + this.caixa);

    }

    public void EntregarPedido() {
        ArrayList<String> chaves = new ArrayList<>(dicionario.keySet());
        int i = 0;
        while (this.dicionario.size() > 0) {
            String chave = chaves.get(i);
            System.out.println("Pedido entregue ao Cliente " + chave);
            this.dicionario.remove(chave);
            System.out.println(dicionario.size());
            i += 1;
        }

       
    }

    public float getCaixa() {
        return this.caixa;
    }

}
