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
        game.roll(2, 8);
        game.roll(6, 0); // bonus roll
        Assertions.assertEquals(133, game.calculateTotalScore());
    }

    @Test
    void allFive() {
        for (int i = 0; i < 10; i++) {
            game.roll(5, 5);
        }
        game.roll(5, 0);
        // 10x10 + 10x nextRoll = 150
        Assertions.assertEquals(150, game.calculateTotalScore());
    }

    @Test
    void noSparesOrStrikes() {
        for (int i = 0; i < 10; i++) {
            game.roll(1, 1);
        }
        // 10x2=20
        Assertions.assertEquals(20, game.calculateTotalScore());

    }

    @Test
    void perfectGame() {
        for (int i = 0; i < 11; i++) {
            game.roll(10, 0);
        }
        //10x10+9x20+10
        Assertions.assertEquals(290, game.calculateTotalScore());
    }

    @Test
    void intermediateResults() {
        // TODO
    }

}
