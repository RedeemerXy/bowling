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
        game.addFrame(new Frame(1, 4));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(6, 4));
        game.addFrame(new Frame(5, 5));
        game.addFrame(new Frame(10, 0));
        game.addFrame(new Frame(0, 1));
        game.addFrame(new Frame(7, 3));
        game.addFrame(new Frame(6, 4));
        game.addFrame(new Frame(10, 0));
        game.addFrame(new Frame(2, 8));
        game.addFrame(new Frame(6, 0)); // bonus roll
        Assertions.assertEquals(133, game.calculateTotalScore());
    }

    @Test
    void allFive() {
        for (int i = 0; i < 10; i++) {
            game.addFrame(new Frame(5, 5));
        }
        game.addFrame(new Frame(5, 0));
        // 10x10 + 10x nextRoll = 150
        Assertions.assertEquals(150, game.calculateTotalScore());
    }

    @Test
    void noSparesOrStrikes() {
        for (int i = 0; i < 10; i++) {
            game.addFrame(new Frame(1, 1));
        }
        // need to add dummy bonus frame to avoid IndexOutOfBoundsException,
        // values are irrelevant because bonus frame score stays 0
        game.addFrame(new Frame(7, 3));
        // 10x2=20
        Assertions.assertEquals(20, game.calculateTotalScore());

    }

    @Test
    void perfectGame() {
        for (int i = 0; i < 11; i++) {
            game.addFrame(new Frame(10, 0));
        }
        //10x10+9x20+10
        Assertions.assertEquals(290, game.calculateTotalScore());
    }

}
