package ru.netology.manager;
import ru.netology.domain.FilmItem;
import ru.netology.repository.AfishaRepository;


public class AfishaManager {

    private int countFilms;
    private int defaultCountFilms = 10;
    private AfishaRepository repo;

    public AfishaManager(AfishaRepository repo, int countFilms) {
        this.repo = repo;
        this.countFilms = countFilms;
    }
    public void setCountFilms(int countFilms) {

        this.countFilms = countFilms;
    }

    public AfishaManager(AfishaRepository repository) {

        this.repo = repo;
    }



    public void addFilm(FilmItem film) {

        repo.save(film);
    }

    public FilmItem[] showAll() {
        return repo.findAll();
    }

  public FilmItem[] getFindLast() {
        FilmItem[] films = repo.findAll();
        int lenght = films.length;
        if(countFilms <= 0) {
            if(defaultCountFilms < lenght)
            lenght = defaultCountFilms;
        } else{
            if (countFilms < lenght){
                lenght = countFilms;
            }
        }

        FilmItem[] result = new FilmItem[lenght];
        for (int i = 0; i < result.length; i++) {
            result[i] = films[films.length - 1 - i];

        }
        return result;
    }

}

