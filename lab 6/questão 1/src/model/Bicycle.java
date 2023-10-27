package model;

public class Bicycle implements CarbonFootPrint{


    private int km;
    
    public Bicycle(int km){
        this.km = km;
    }

    public double getCarbonFootPrint(){

        return this.km * 0.6;
    }
}
