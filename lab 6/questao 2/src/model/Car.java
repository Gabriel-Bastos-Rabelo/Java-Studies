package model;

public class Car implements CarbonFootPrint, Comparable<Car> {

    private String fuelType;
    private double mileage;
    private double pegadaDeCarbonoPorhora;
    private int minutos;
    public Car(String fuelType, double mileage, int minutos){
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.minutos = minutos;
        this.pegadaDeCarbonoPorhora = getCarbonFootPrint(this.minutos);
       
        
    }

   
    @Override

    public double getCarbonFootPrint(){
       if(fuelType.equalsIgnoreCase("gasolina")){
            return 2.3 * mileage;
       }
       else if(fuelType.equalsIgnoreCase("diesel")){
            return 2.7 * mileage;
       }
       else{
            return 0;
       }
    }

    public double getCarbonFootPrint(int minuto){
        if(fuelType.equalsIgnoreCase("gasolina")){
            return 2.3 * mileage / (minutos/ 60);
       }
       else if(fuelType.equalsIgnoreCase("diesel")){
            return 2.7 * mileage / (minutos / 60);
       }
       else{
            return 0;
       }
    }


    public double getPegadaDeCarbonoPorHora(){
        return this.pegadaDeCarbonoPorhora;
    }

    public int compareTo(Car c){
        if(this.pegadaDeCarbonoPorhora > c.pegadaDeCarbonoPorhora){
            return 1;
        }
        else if(this.pegadaDeCarbonoPorhora < c.pegadaDeCarbonoPorhora){
            return -1;
        }
        
        return 0;
    }

}
