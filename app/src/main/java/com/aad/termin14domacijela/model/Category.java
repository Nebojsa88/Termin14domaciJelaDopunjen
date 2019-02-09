package com.aad.termin14domacijela.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String name;
    private List<Jelo> jela;


    public Category(){
        jela = new ArrayList<>();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Jelo> getJela() {
        return jela;
    }

    public void setJela(List<Jelo> jela) {
        this.jela = jela;
    }
    public void addJelo(Jelo jelo){
        jela.add(jelo);
    }
    public void removeJelo(Jelo jelo){
        jela.remove(jelo);
    }
    public Jelo getJelo(int position){
        return jela.get(position);
    }

    @Override
    public String toString() {
        return name;
    }
}
