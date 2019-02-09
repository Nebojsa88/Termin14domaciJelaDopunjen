package com.aad.termin14domacijela.provider;

import com.aad.termin14domacijela.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryProvider {

    public static List<Category> getCategories(){
        List<Category> categories = new ArrayList<>();

        categories.add(new Category(0, "Pizza"));
        categories.add(new Category(1, "Rostilj"));
        categories.add(new Category(2, "Paste"));
        return categories;
    }
    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("Pizza");
        names.add("Rostilj");
        names.add("Paste");
        return names;
    }
    public static Category getCategoryByName(int id){
        switch (id){
            case 0:
                return new Category(0, "Pizza");
            case 1:
                return new Category(1, "Rostilj");
            case 2:
                return new Category(2, "Paste");
                default:
                    return null;
        }
    }
}
