package model;

import java.time.LocalDate;

public class Caminhada extends AtividadeFisica {
    protected int ritmo;
    protected int trajeto;


    public Caminhada(int tempo, LocalDate data, int calorias, int ritmo, int trajeto){
        super(tempo, data, calorias);
        this.ritmo = ritmo;
        this.trajeto = trajeto;
    }



    public int calcularCalorias(){
        return this.calorias;
    }


    public int getRitmo(){
        return this.ritmo;
    }

    public int getTrajeto(){
        return this.trajeto;
    }

   
}
