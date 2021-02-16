import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    Quiz q;

    @BeforeEach
    void setUp() {
        //300	WORLD CAPITALS	Home to NATO & little green sprouts	Brussels
        q = new Quiz();
    }

    @Test
    void testLoadQuestions() {
        assertTrue(true);

    }

    @Test
    void switchQ() {
    }

    @Test
    void loadNextRound() {
        q.loadNextRound();
        System.out.println("break ..");
        q.switchQ();
        System.out.println("break ..");
        q.loadNextRound();
        System.out.println("break ..");
        q.switchQ();
        System.out.println("break ..");
    }
}