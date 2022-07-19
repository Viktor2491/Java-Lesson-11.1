package ru.netology.manager;
import ru.netology.domain.FilmItem;


public class AfishaManager {

    private int countFilms;
    private FilmItem[] films = new FilmItem[0];

    public AfishaManager() {
        this.countFilms = 10;

    }
    public AfishaManager(int countFilms) {
        this.countFilms = countFilms;
    }



    public void addFilm(FilmItem film) {
        FilmItem[] tmp = new FilmItem[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public FilmItem[] findAll() {

        return films;

    }
    public FilmItem[] findLast() {
        int resultLenght;
        if(films.length >= countFilms) {
            resultLenght = countFilms;
        } else{
            resultLenght = films.length;
        }

        FilmItem[] result = new FilmItem[resultLenght];
        for (int i = 0; i < result.length; i++) {
            result[i] = films[films.length - 1 - i];

        }
        return result;
    }
}

