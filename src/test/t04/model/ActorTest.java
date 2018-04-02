package test.t04.model;

import main.t04.model.Actor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Ekaterina Semenova on 26.03.2018.
 */
@DisplayName("Actor test")
public class ActorTest {
    @Test
    @DisplayName("Returns \"Name Surname\"")
    void toStringTest() {
        Actor actor = new Actor("Хью", "Джекман");
        assertEquals("Хью Джекман", actor.toString());
    }
}
