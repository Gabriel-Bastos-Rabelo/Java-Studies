package model;

import java.lang.Comparable;

public class Building implements CarbonFootPrint, Comparable<Building>{

    private double area;
    private double pegadaDeCarbonoPorhora;
    private String fuelType;
    private int hora;
    public Building(double area, String fuelType, int hora){
        this.area = area;
        this.hora = hora;
        this.fuelType = fuelType;
        this.pegadaDeCarbonoPorhora = getCarbonFootPrint(this.hora);
    }



    @Override
    public double getCarbonFootPrint(){
        if(fuelType.equalsIgnoreCase("gás")){
            return area * 0.2;
        }
        else if(fuelType.equalsIgnoreCase("eletricidade")){
            return area * 0.1;
        }
        else{
            return 0;
        }
    }


    public double getCarbonFootPrint(int hora){

        if(fuelType.equalsIgnoreCase("gás")){
            return area * 0.2/hora;
        }
        else if(fuelType.equalsIgnoreCase("eletricidade")){
            return area * 0.1/hora;
        }
        else{
            return 0;
        }

    }

    public double getPegadaDeCarbonoPorHora(){
        return this.pegadaDeCarbonoPorhora;
    }


    
    public int compareTo(Building b) {
        if(this.pegadaDeCarbonoPorhora > b.pegadaDeCarbonoPorhora ){
            return 1;
        }
        else if(this.pegadaDeCarbonoPorhora < b.pegadaDeCarbonoPorhora){
            return -1;
        }

        return 0;
    }



    




    
}