package test.t04.model;

import main.t04.model.Film;
import main.t04.model.FilmCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Ekaterina Semenova on 27.03.2018.
 */
public class FilmCollectionTest {
    private Film film1;
    private Film film2;
    private FilmCollection filmCollection1;
    private FilmCollection filmCollection2;

    @BeforeEach
    void setUp() {
        filmCollection1 = new FilmCollection();
        filmCollection2 = new FilmCollection();
        film1 = new Film("Film", 2000);
        filmCollection1.addFilm(film1);

    }

    @Test
    @DisplayName("deleteFilm() Test")
    void deleteFilmTest() {
        filmCollection1.deleteFilm(film1);
        assertEquals(filmCollection2, filmCollection1);

    }
}
