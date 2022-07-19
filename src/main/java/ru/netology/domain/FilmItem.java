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
}