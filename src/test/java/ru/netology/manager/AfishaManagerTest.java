package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.AfishaRepository;

import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class AfishaManagerMockitoTest {
    @Mock
    private AfishaRepository repo;
    @InjectMocks

    AfishaManager manager = new AfishaManager(repo);


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
        manager.addFilm(film1);
        manager.addFilm(film2);
        manager.addFilm(film3);
        manager.addFilm(film4);
        manager.addFilm(film5);
        manager.addFilm(film6);
        manager.addFilm(film7);
        manager.addFilm(film8);
        manager.addFilm(film9);
        manager.addFilm(film10);
        manager.addFilm(film11);
        manager.addFilm(film12);
        manager.addFilm(film13);
    }


    @Test
    void shouldShowTenMovie() {
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        doReturn(returned).when(repo).findAll();
        FilmItem[] actual = manager.getFindLast();
        FilmItem[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void shouldShowMoreThanTen() {
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12, film13};
        doReturn(returned).when(repo).findAll();
        FilmItem[] actual = manager.getFindLast();
        FilmItem[] expected = {film13, film12, film11, film10, film9, film8, film7, film6, film5, film4};
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    void mustShowLessThanTen() {
        FilmItem[] returned = new FilmItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9};
        doReturn(returned).when(repo).findAll();
        FilmItem[] actual = manager.getFindLast();
        FilmItem[] expected = {film9, film8, film7, film6, film5, film4, film3, film2, film1};
        Assertions.assertArrayEquals(expected, actual);

    }
}

