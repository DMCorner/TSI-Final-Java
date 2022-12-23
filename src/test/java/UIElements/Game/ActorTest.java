package UIElements.Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    @Test
    public void testActor() {
        Actor testActor = new Actor();
        Assertions.assertInstanceOf(Actor.class, testActor, "testActor should be actor class");
    }

    @Test
    public void testFilmsAndActors() {
        Film_Actor testFilmAndActor = new Film_Actor();
        Assertions.assertInstanceOf(Film_Actor.class, testFilmAndActor, "testFilmAndActor should be Film_Actor class");
    }
}
