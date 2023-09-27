public class Beneficios {
    private String nome;
    private float value;


    public Beneficios(String nome, float value){
        this.nome = nome;
        this.value = value;
    }


    public String getNome(){
        return this.nome;
    }

    public float getValue(){
        return this.value;
    }
}
