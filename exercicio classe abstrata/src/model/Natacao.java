package model;

import java.time.LocalDate;

public class Natacao extends AtividadeFisica {
    
    protected int volta;
    protected int metragem;
    
    
    public Natacao(int tempo, LocalDate data, int calorias, int volta, int metragem){
        super(tempo, data, calorias);
        this.volta = volta;
        this.metragem = metragem;
    }



    public int calcularCalorias(){
        return this.calorias;
    }

    public int getVoltas(){
        return this.volta;
    }


    public int getMetragem(){
        return this.metragem;
    }


    
}
