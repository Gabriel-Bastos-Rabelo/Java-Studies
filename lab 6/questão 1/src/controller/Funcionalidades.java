package controller;
import java.util.ArrayList;

import model.*;

public class Funcionalidades {

    ArrayList<CarbonFootPrint> carbonFootPrintList;

    public Funcionalidades(){
        carbonFootPrintList = new ArrayList<CarbonFootPrint>();
    }
    public void adicionarCarro(int km){
        Car newCarro = new Car(km);
        carbonFootPrintList.add(newCarro);
    }


    public void adicionarBicicleta(int km){
        Bicycle newBicicleta = new Bicycle(km);
        carbonFootPrintList.add(newBicicleta);
    }

    public void adicionarBulding(double area){
        Building newBuilding = new Building(area);
        carbonFootPrintList.add(newBuilding);
    }



    public ArrayList<CarbonFootPrint> getPegadaCarbono(){
        return carbonFootPrintList;
    }
}
