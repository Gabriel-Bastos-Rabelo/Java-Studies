public class Cliente {
    private String name;
    private float valor;

    public Cliente(String name, float valor) {
        this.name = name;
        this.valor = valor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getName() {
        return this.name;
    }

    public float getValor() {
        return this.valor;
    }
}
