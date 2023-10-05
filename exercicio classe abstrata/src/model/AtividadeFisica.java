package model;

import java.time.LocalDate;

public abstract class AtividadeFisica{


    protected int tempo;
    protected LocalDate data;
    protected int calorias;

    public AtividadeFisica(int tempo, LocalDate data, int calorias){
        this.tempo = tempo;
        this.data = data;
        this.calorias = calorias;
    }



    public abstract int calcularCalorias();

    public int getTempo(){
        return this.tempo;
    }

    public LocalDate getData(){

        return this.data;
    }





}