package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Operazioni_Arraylist {
    Gson gson=new Gson();
    ArrayList<Piatto> arr;
    Operazioni_Arraylist(){
        arr=new ArrayList<Piatto>();
    }

    void add_Prodotti(String nome,int id,String descrizione,double costo){
        Piatto a=new Piatto(nome, id ,descrizione,costo);
        arr.add(a);
    }


    void crea_lista() {
        add_Prodotti("pasta al pesto", 1, "pasta al pesto", 12.50);
        add_Prodotti("pasta allo scoglio", 2, "pasta con frutti di mare", 15.05);
        add_Prodotti("fritto misto", 3, "frittura mista di prodotti marini", 20.99);
        add_Prodotti("pizza margherita", 1, "pizza pomodoro mozzarella e basilico", 10);
    }

    String all(){
        String msg="All our plates: ";
        for (int i = 0; i < arr.size(); i++) {
            msg=msg+arr.get(i).toString();
        }
        return "All our plates: "+msg;
    }

    String minorPrice(){
        arr.sort((Piatto p1, Piatto p2)->(int) (p1.costo+p2.costo));
        return "More Expensive "+arr.get(0).toString();
    }

    String sort(){
        arr.sort((Piatto p1, Piatto p2)->(int) (p2.costo-p1.costo));
        return "All Sorted by price" + gson.toJson(arr);
    }
}