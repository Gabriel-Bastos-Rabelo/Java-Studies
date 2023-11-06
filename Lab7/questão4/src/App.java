import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import controller.Funcionalidades;
import models.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        Funcionalidades funcionalidades = new Funcionalidades();
        Hashtable<String, ArrayList<Pessoa>> hashtable = new Hashtable<>();

        Pessoa p1 = new Pessoa("Gabriel", "987987823423");
        Pessoa p2 = new Pessoa("João", "8234798273");
        Pessoa p3 = new Pessoa("Ribamar", "2341234324");
        funcionalidades.inserirNoHash(hashtable, "bastos", p1);
        funcionalidades.inserirNoHash(hashtable, "bastos", p2);
        funcionalidades.inserirNoHash(hashtable, "costa", p3);


        Enumeration<String> e = hashtable.keys();
 
       
        while (e.hasMoreElements()) {
 
            
            String key = e.nextElement();

            for(Pessoa p : hashtable.get(key)){
                System.out.println("Key: " + key + " Name: " + p.getNome() + " CPF: " + p.getCPF());
            }
 
            
            
        }






    }
}
