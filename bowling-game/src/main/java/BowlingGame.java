public class BowlingGame {
    int[] rolls = new int[22];
    int index = 0;

    public void roll(int pin) {
        rolls[index++] = pin;
    }

    public int score() {
        int score = 0;
        int step;

        for (int rollsIndex = 0; rollsIndex < index - 1; rollsIndex += step) {
            Integer firstRoll = rolls[rollsIndex];
            Integer secondRoll = rolls[rollsIndex + 1];

            if (isStrike(firstRoll)) {
                Integer firstRollNextFrame = rolls[rollsIndex + 1];
                Integer secondRollNextFrame = rolls[rollsIndex + 2];
                score += 10 + firstRollNextFrame + secondRollNextFrame;
                step = 1;
            } else if (isSpare(firstRoll, secondRoll)) {
                Integer firstRollNextFrame = rolls[rollsIndex + 2];
                score += 10 + firstRollNextFrame;
                step = 2;
            } else {
                score += firstRoll + secondRoll;
                step = 2;
            }
        }

        return score;
    }

    private boolean isStrike(Integer firstRoll) {
        return firstRoll == 10;
    }

    private boolean isSpare(int firstRoll, int secondRoll) {
        return firstRoll + secondRoll == 10;
    }
}
