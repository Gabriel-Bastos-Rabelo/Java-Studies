package model;

import java.time.LocalDate;

public class Musculacao extends AtividadeFisica{
    

    protected int carga;
    protected int repeticoes;

    public Musculacao(int tempo, LocalDate data, int calorias, int carga, int repeticoes){
        super(tempo, data, calorias);
        this.carga = carga;
        this.repeticoes = repeticoes;
    }



    public int calcularCalorias(){
        return this.calorias;
    }


    public int getCarga(){
        return this.carga;
    }

    public int getRepeticoes(){
        return this.repeticoes;
    }

    
}
