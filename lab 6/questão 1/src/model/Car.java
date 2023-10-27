package model;

public class Car implements CarbonFootPrint {

    private int km;
    public Car(int km){
        this.km = km;
       
        
    }

   

    public double getCarbonFootPrint(){
        return this.km * 1.5;
    }

    
}
