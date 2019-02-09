package com.aad.termin14domacijela.model;

public class Jelo {

    private int id;
    private String naziv;
    private String opis;
    private Category category;
    private String sastojci;
    private float rating;
    private String image;
    private int kalorijskaVrednost;
    private double cena;

    public Jelo(){

    }

    public Jelo(int id, String naziv, String opis, Category category, String sastojci, String image, int kalorijskaVrednost, double cena, float rating) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.category = category;
        this.sastojci = sastojci;
        this.image = image;
        this.kalorijskaVrednost = kalorijskaVrednost;
        this.cena = cena;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSastojci() {
        return sastojci;
    }

    public void setSastojci(String sastojci) {
        this.sastojci = sastojci;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getKalorijskaVrednost() {
        return kalorijskaVrednost;
    }

    public void setKalorijskaVrednost(int kalorijskaVrednost) {
        this.kalorijskaVrednost = kalorijskaVrednost;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Jelo{" +
                "naziv='" + naziv + '\'' +
                '}';
    }
}
