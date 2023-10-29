package controller;
import java.util.ArrayList;
import java.util.Collections;

import model.*;


public class Funcionalidades {

    ArrayList<CarbonFootPrint> carbonFootPrintList;
    ArrayList<String> listaPalavras;
    ArrayList<Building> listaPredio;

    public Funcionalidades(){
        carbonFootPrintList = new ArrayList<CarbonFootPrint>();
        listaPalavras = new ArrayList<String>();
        listaPredio = new ArrayList<Building>();
    }
    public void adicionarCarro(int mileage, String fuelType, int minutos){
        Car newCarro = new Car(fuelType, mileage, minutos);
        carbonFootPrintList.add(newCarro);
        
    }


    public void adicionarBicicleta(int minutos){
        Bicycle newBicicleta = new Bicycle(minutos);
        carbonFootPrintList.add(newBicicleta);
    }

    public void adicionarBulding(double area, String fuelType, int hora){
        Building newBuilding = new Building(area, fuelType, hora);
        carbonFootPrintList.add(newBuilding);
    }



    public ArrayList<CarbonFootPrint> getPegadaCarbono(){
        return carbonFootPrintList;
    }


    public void sortear(){
        for(CarbonFootPrint c: carbonFootPrintList){
            
        }

       

        
    }
}
