package test.t04.model;

import main.t04.model.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Ekaterina Semenova on 27.03.2018.
 */
public class FilmTest {
    private Film film1;
    private Film film2;

    @BeforeEach
    void setUp() {
        film1 = new Film("Film", 2000);
        film2 = new Film("Film", 2000);
    }

    @Test
    @DisplayName("hashCode() returns equal integer for equal films")
    void hashCodeTest() {
        assertEquals(film1.hashCode(), film2.hashCode());
    }
}
