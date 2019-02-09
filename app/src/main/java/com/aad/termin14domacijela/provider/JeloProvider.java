package com.aad.termin14domacijela.provider;

import com.aad.termin14domacijela.model.Category;
import com.aad.termin14domacijela.model.Jelo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class JeloProvider {

    public static List<Jelo> getJela(){

        Category pizza = new Category(0, "Pizza");
        Category rostilj = new Category(1, "Rostilj");
        Category paste = new Category(2, "Paste");

        List<Jelo> jela = new ArrayList<>();

               jela.add(new Jelo(0, "Cevapi", "Cevapi u lepinji", rostilj ,  "mleveno meso, biber, luk", "cevapi.jpg",  2554, 300, 3f));
               jela.add(new Jelo(1, "Spagete", "Bolonjeze", paste, "testo, mleveno meso, preliv, paradajz", "spagete.jpg", 1500, 450, 4f));
               jela.add(new Jelo(2, "Pizza", "pizza Napolitana", pizza, "testo, sampinjoni, sir, kulen", "pizza.jpg", 1200,600 , 5f));
            return jela;

    }
    public static List<String> getJalaNames(){
        List<String>names = new ArrayList<>();
        names.add("Cevapi");
        names.add("Spagete");
        names.add("Pizza");
        return names;
    }
    public static Jelo getJeloById(int id){

        Category pizza = new Category(0, "Pizza");
        Category rostilj = new Category(1, "Rostilj");
        Category paste = new Category(2, "Paste");

        switch (id){
                case 0:
                    return new Jelo(0, "Cevapi", "Cevapi u lepinji", rostilj, "mleveno meso, biber, luk", "cevapi.jpg",  2554, 300, 3f);
                case 1:
                    return new Jelo(1, "Spagete", "Bolonjeze", paste, "testo, mleveno meso, preliv, paradajz", "spagete.jpg", 1500, 450, 4f);
                case 2:
                    return new Jelo(2, "Pizza", "pizza Napolitana", pizza, "testo, sampinjoni, sir, kulen", "pizza.jpg", 1200,600, 5f );
                default:
                    return null;

        }
    }


}
