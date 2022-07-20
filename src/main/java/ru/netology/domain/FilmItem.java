package ru.netology.domain;

public class FilmItem {
    private int id;
    private int filmPrice;
    private String filmName;

    public FilmItem(int id, int filmPrice, String filmName) {
        this.id = id;
        this.filmPrice = filmPrice;
        this.filmName = filmName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmPrice() {
        return filmPrice;
    }

    public void setFilmPrice(int productId) {
        this.filmPrice = filmPrice;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setProductName(String productName) {
        this.filmName = filmName;
    }

}