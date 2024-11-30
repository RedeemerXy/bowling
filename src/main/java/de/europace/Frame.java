package de.europace;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Frame {

    private final int firstRoll;
    private final int secondRoll;
    // potential bonus roll on last frame
    private final int thirdRoll;
    @Setter
    private Frame next;

    public Frame(int firstRoll, int secondRoll) {
        this(firstRoll, secondRoll, 0);
    }

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public boolean isSpare() {
        return !isStrike() && firstRoll + secondRoll == 10;
    }

    public int calculateScore() {
        int frameScore = firstRoll + secondRoll + thirdRoll;

        if (next == null) {
            return frameScore;
        }

        if (isSpare() || isStrike()) {
            frameScore += next.getFirstRoll();
        }

        if (isStrike()) {
            if (!next.isStrike()) {
                frameScore += next.getSecondRoll();
            } else {
                Frame secondNext = next.getNext();
                if (secondNext != null) {
                    frameScore += secondNext.getFirstRoll();
                }
            }
        }
        return frameScore;
    }

}
