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
		int pointer = 0;

		for (int i = 0; i < 10; i++) {
			
			//count strike point
			if (rolls[pointer] == 10) {
				score += 10 + rolls[pointer+1] + rolls[pointer+2];
				pointer++;
			} 
			//count spare point
			else if (rolls[pointer] + rolls[pointer+1] == 10) {
				score += 10 + rolls[pointer+2];
				pointer += 2;
			} 
			//normal scoring
			else {
				score += (rolls[pointer] + rolls[pointer+1]);
				pointer += 2;
			}
		}

		return score;
	}
	
}
