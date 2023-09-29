package Model;

public class Vendas {
    private String data;
    private float valor;
    private boolean status;

    public Vendas(String data, float valor, boolean status){
        this.data = data;
        this.valor =valor;
        this.status = status;
    }

    public float getValor(){
        return this.valor;
    }

    public String getDate(){
        return this.data;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
}
