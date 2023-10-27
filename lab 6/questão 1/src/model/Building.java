package model;

public class Building implements CarbonFootPrint{

    private double area;
    public Building(double area){
        this.area = area;
    }


    public double getCarbonFootPrint(){
        return area * 3.2;
    }
}