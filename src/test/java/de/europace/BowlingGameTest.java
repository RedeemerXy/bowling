package de.europace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BowlingGameTest {

    BowlingGame game;

    @BeforeEach
    void setup() {
        game = new BowlingGame();
    }

    @Test
    void exampleFromChallenge() {
        game.roll(1, 4);
        game.roll(4, 5);
        game.roll(6, 4);
        game.roll(5, 5);
        game.roll(10, 0);
        game.roll(0, 1);
        game.roll(7, 3);
        game.roll(6, 4);
        game.roll(10, 0);
        game.roll(2, 8, 6);
        assertScore(133);
    }

    @Test
    void allFive() {
        for (int i = 0; i < 9; i++) {
            game.roll(5, 5);
        }
        game.roll(5, 5, 5);
        // 10x10 + 10x nextRoll = 150
        assertScore(150);
    }

    @Test
    void noSparesOrStrikes() {
        for (int i = 0; i < 10; i++) {
            game.roll(1, 1);
        }
        // 10x2=20
        assertScore(20);

    }

    @Test
    void perfectGame() {
        for (int i = 0; i < 9; i++) {
            game.roll(10, 0);
        }
        game.roll(10, 10, 10);
        //10x10+9x20+10
        assertScore(300);
    }

    @Test
    void intermediateResults() {
        assertScore(0);
        game.roll(0, 1);
        assertScore(1);
        game.roll(2, 3);
        assertScore(6);
        game.roll(5, 5);
        assertScore(16);
        game.roll(1, 2);
        assertScore(20);
        game.roll(10, 0);
        assertScore(30);
        game.roll(1, 2);
        assertScore(36);

    }

    private void assertScore(int expected) {
        Assertions.assertEquals(expected, game.calculateTotalScore());
    }

}
