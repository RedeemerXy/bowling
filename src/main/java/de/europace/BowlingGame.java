package de.europace;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    // every game has ten frames, model bonus roll as eleventh frame?
    private final List<Frame> frames = new ArrayList<>();

    public void addFrame(Frame frame) {
        frames.add(frame);
    }

    public int calculateTotalScore() {
        for (int i = 0; i <= 9; i++) {
            Frame currentFrame = frames.get(i);
            Frame nextFrame = frames.get(i + 1);
            int frameScore = currentFrame.getFirstRoll() + currentFrame.getSecondRoll();
            if (currentFrame.isStrike()) {
                frameScore += nextFrame.getFirstRoll();
                if (!nextFrame.isStrike()) {
                    frameScore += nextFrame.getSecondRoll();
                } else if (i <= 8) {
                    // i=8 means we are on Frame 9 of 11
                    // if we are already on Frame 10, then we are done here
                    // because the single bonus roll is already added in
                    Frame secondNextFrame = frames.get(i + 2);
                    frameScore += secondNextFrame.getFirstRoll();
                }
            } else if (currentFrame.isSpare()) {
                frameScore += nextFrame.getFirstRoll();
            }
            currentFrame.setFrameScore(frameScore);
        }

        int sum = 0;
        for (Frame frame : frames) {
            sum += frame.getFrameScore();
        }
        return sum;
    }
}
