package solBowlingGame;

public class BowlingGame {

	int[] rolls;
	int roll = 0;

	public BowlingGame() {
		this.rolls = new int[21];
	}

	public void roll(int pin) {
		rolls[roll++] = pin;
	}

	public int score() {
		int score = 0;
		int cursor = 0;

		for (int i = 0; i < 10; i++) {
			if (isStrike(cursor)) {
				score += 10 + strikeBonus(cursor);
				cursor++;
			} else if (isSpare(cursor)) {
				score += 10 + spareBonus(cursor);
				cursor += 2;
			} else {
				score += sumOfRolls(cursor);
				cursor += 2;
			}
		}

		return score;
	}

	private boolean isStrike(int cursor) {
		return rolls[cursor] == 10;
	}

	private boolean isSpare(int cursor) {
		return sumOfRolls(cursor) == 10;
	}

	private int strikeBonus(int cursor) {
		return sumOfRolls(cursor+1);
	}

	private int spareBonus(int cursor) {
		return rolls[cursor+2];
	}

	private int sumOfRolls(int cursor) {
		return rolls[cursor] + rolls[cursor+1];
	}
}
