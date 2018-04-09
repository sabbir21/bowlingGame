package solBowlingGame;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class BowlingGameTest {

	private BowlingGame b;

	void countRollTest(int n, int pins, BowlingGame b) {
		for (int i = 0; i < n; i++) b.roll(pins);
	}

	@Before
	public void setUp() {
		this.b = new BowlingGame();
	}

	@Test
	public void testZero() {
		countRollTest(20, 0, b);
		assertEquals(0, b.score());
	}
	
	@Test
	public void testAllOnes() {
		countRollTest(20, 1, b);
		assertEquals(20, b.score());
	}

	@Test
	public void testSpareOnce() {
		b.roll(2);
		b.roll(8);
		b.roll(6);
		countRollTest(17, 0, b);
		assertEquals(22, b.score());
	}
	
	@Test
	public void testStrikeOnce() {
		b.roll(10);
		b.roll(3);
		b.roll(4);
		countRollTest(16, 0, b);
		assertEquals(24, b.score());
	}
	
	@Test
	public void testFullSpare() {
		countRollTest(21, 5, b);
		assertEquals(150, b.score());
	}
	
	@Test
	public void testFullStrike() {
		countRollTest(12, 10, b);
		assertEquals(300, b.score());
	}

}
