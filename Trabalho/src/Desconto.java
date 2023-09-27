public class Desconto {
    private String nome;
    private float valorPerc;
    private float valorNum;


    public Desconto(String nome, float valorPerc, float valorNum) {
        this.nome = nome;
        
        if(valorPerc == -1){
            this.valorPerc = 0;
            this.valorNum = valorNum;
        }
        else{
            this.valorPerc = valorPerc;
            this.valorNum = 0;
        }
    }

    public String getNome(){
        return this.nome;
    }

    public float getValorPerc(){
        return this.valorPerc;
    }

    public float getValorNum(){
        return this.valorNum;
    }
}
