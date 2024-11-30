package de.europace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrameTest {

    // TODO: parameterized test
    @Test
    void singleFrame() {
        assertEquals(0, new Frame(0, 0).calculateScore());
        assertEquals(4, new Frame(4, 0).calculateScore());
        assertEquals(4, new Frame(0, 4).calculateScore());
        assertEquals(7, new Frame(3, 4).calculateScore());
        assertEquals(10, new Frame(4, 6).calculateScore());
        assertEquals(10, new Frame(10, 0).calculateScore());
    }

    @Test
    void spare() {
        Frame frame = new Frame(4, 6);
        assertEquals(10, frame.calculateScore());
        Frame next = new Frame(1, 1);
        frame.setNext(next);
        assertEquals(11, frame.calculateScore());
        next.setNext(new Frame(1, 1));
        assertEquals(11, frame.calculateScore());
    }

    @Test
    void nonConsecutiveStrike() {
        Frame frame = new Frame(10, 0);
        assertEquals(10, frame.calculateScore());
        Frame next = new Frame(1, 2);
        frame.setNext(next);
        assertEquals(13, frame.calculateScore());
        next.setNext(new Frame(3, 4));
        assertEquals(13, frame.calculateScore());
    }

    @Test
    void consecutiveStrike() {
        Frame frame = new Frame(10, 0);
        assertEquals(10, frame.calculateScore());
        Frame next = new Frame(10, 0);
        frame.setNext(next);
        assertEquals(20, frame.calculateScore());
        next.setNext(new Frame(3, 4));
        assertEquals(23, frame.calculateScore());
    }
}
