package de.europace;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Frame {

    private final int firstRoll;
    private final int secondRoll;
    // sum of rolls plus bonuses
    @Setter
    private int frameScore;

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public boolean isSpare() {
        return !isStrike() && firstRoll + secondRoll == 10;
    }

//    public void calculateScore(int nextRoll, int secondNextRoll) {
//        frameScore = firstRoll + secondRoll;
//        if (isStrike()) {
//            frameScore += nextRoll + secondNextRoll;
//        } else if (isSpare()) {
//            frameScore += nextRoll;
//        }
//    }

}
