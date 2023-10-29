package model;

public class Bicycle implements CarbonFootPrint, Comparable<Bicycle>{


    private double pegadaDeCarbonoPorhora;
    private int minutos;
    
    public Bicycle(int minutos){

        this.minutos = minutos;
        
        this.pegadaDeCarbonoPorhora = getCarbonFootPrint(this.minutos);
    }

    @Override

    public double getCarbonFootPrint(){

        return 0;
    }

    public double getCarbonFootPrint(int minutos){
        return 0;
    }

    public double getPegadaDeCarbonoPorHora(){
        return this.pegadaDeCarbonoPorhora;
    }


    public int compareTo(Bicycle b){
        if(this.pegadaDeCarbonoPorhora > b.pegadaDeCarbonoPorhora){
            return 1;
        }
        else if(this.pegadaDeCarbonoPorhora < b.pegadaDeCarbonoPorhora){
            return -1;
        }
        else{
            return 0;
        }
    }
}
