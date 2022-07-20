package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;


public class AfishaRepositoryTest {
     AfishaRepository repo = new AfishaRepository();

     FilmItem film1 = new FilmItem(1, 200, "Бладшот");
     FilmItem film2 = new FilmItem(2, 220, "Вперед");
     FilmItem film3 = new FilmItem(3, 250, "Отель «Белград»");
     FilmItem film4 = new FilmItem(4, 270, "Джентльмены");
     FilmItem film5 = new FilmItem(5, 300, "Человек-невидимка");
     FilmItem film6 = new FilmItem(6, 320, "Тролли. Мировой тур");
     FilmItem film7 = new FilmItem(7, 350, "Номер один");
     FilmItem film8 = new FilmItem(8, 370, "Один дома");
     FilmItem film9 = new FilmItem(9, 400, "Бэтмен. Начало");
     FilmItem film10 = new FilmItem(10, 420, "Елки");
     FilmItem film11 = new FilmItem(11, 450, "Елки 2");
     FilmItem film12 = new FilmItem(12, 470, "Елки 3");
     FilmItem film13 = new FilmItem(13, 470, "Елки 4");


    @BeforeEach
    public void setup() {

        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        repo.save(film7);
        repo.save(film8);
        repo.save(film9);
        repo.save(film10);
        repo.save(film11);
        repo.save(film12);
        repo.save(film13);
    }

    @Test
    public void shouldFindAll() {

        repo.findAll();
        FilmItem[] expected = {
                film1,
                film2,
                film3,
                film4,
                film5,
                film6,
                film7,
                film8,
                film9,
                film10,
                film11,
                film12,
                film13
        };
        FilmItem[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave(){
        FilmItem filmToAdd = new FilmItem(14,500,"Елки 5");
        repo.save(filmToAdd);
        FilmItem[] expected = repo.findAll();
        FilmItem[] actual = {
                film1,
                film2,
                film3,
                film4,
                film5,
                film6,
                film7,
                film8,
                film9,
                film10,
                film11,
                film12,
                film13,
               filmToAdd
        };
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindById() {

        FilmItem expected = film12;
        FilmItem actual = repo.findById(12);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {

        FilmItem expected = null;
        FilmItem actual = repo.findById(100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repo.removeById(1);
        FilmItem[] expected = {
                film2,
                film3,
                film4,
                film5,
                film6,
                film7,
                film8,
                film9,
                film10,
                film11,
                film12,
                film13
        };
        FilmItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

@Test
    public void shouldRemoveAll() {

        repo.removeAll();
        FilmItem[] expected = {};
        FilmItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}


