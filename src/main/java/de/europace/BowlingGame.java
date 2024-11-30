package de.europace;

public class BowlingGame {

    private Frame first = null;
    private Frame last = null;

    public void roll(int first, int second) {
        addFrame(new Frame(first, second));
    }

    private void addFrame(Frame frame) {
        if (first == null) {
            first = last = frame;
        } else {
            last.setNext(frame);
            last = frame;
        }
    }

    public int calculateTotalScore() {
        Frame current = first;
        int sum = 0;
        while (current != null) {
            sum += current.calculateScore();
            printFrame(current, sum);
            current = current.getNext();
        }
        return sum;
    }

    private void printFrame(Frame frame, int sum) {
        StringBuilder sB = new StringBuilder();
        sB.append(String.format("%02d", frame.getFirstRoll()));
        sB.append(" | ");
        sB.append(String.format("%02d", frame.getSecondRoll()));
        sB.append(" | ");
        sB.append(String.format("%03d", sum));
        System.out.println(sB);
    }
}
