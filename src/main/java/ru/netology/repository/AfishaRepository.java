package ru.netology.repository;

import ru.netology.domain.FilmItem;

public class AfishaRepository {

    private FilmItem[] films = new FilmItem[0];

    public FilmItem[] findAll() {
        return films;
    }

    public void save(FilmItem film) {
        FilmItem[] tmp = new FilmItem[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }


    public FilmItem findById(int id) {
        for (FilmItem film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        FilmItem[] tmp = new FilmItem[films.length - 1];
        int copyToIndex = 0;
        for (FilmItem film : films) {
            if (film.getId() != id) {
                tmp[copyToIndex] = film;
                copyToIndex++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new FilmItem[0];
    }
}