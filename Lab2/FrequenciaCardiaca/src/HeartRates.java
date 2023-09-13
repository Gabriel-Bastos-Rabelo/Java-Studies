import java.util.Calendar;

public class HeartRates {

    private String nome;
    private String sobrenome;
    private int dia;
    private int mes;
    private int ano;

    public HeartRates(String nome, String sobrenome, int dia, int mes, int ano) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    

    public int getIdade(){
        int idade;
        Calendar calendario = Calendar.getInstance();
        int mes = calendario.get(Calendar.MONTH) + 1; 
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int ano = calendario.get(Calendar.YEAR);
        if(mes > this.mes){
            idade = ano - this.ano;
        }
        else if(mes == this.mes){
            if(dia >= this.dia){
                idade = ano - this.ano;
            }
            else{
                idade = (ano - this.ano) - 1;
            }
        }

        else{
            idade = (ano - this.ano) - 1;
        }

        return idade;

    }

    public int getFreqMax(){
        return (220 - getIdade());
    }

    public String getFreqAlvo(){
        int minimo = (getFreqMax() * 50)/100;
        int maximo = (getFreqMax() * 85)/100;

        return "Sua frequência alvo é entre " + minimo + " e " + maximo + ".";
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
