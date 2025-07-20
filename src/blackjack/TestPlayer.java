package blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlayer {
	
	@Test
	void testAddCard() {
		Player player = new Player("TESTPLAYER");
		
		// sum <= 21, true
		Card c1 = new Card(Suit.Club, 5);
		assertTrue(player.addCard(c1));
		
		// sum <= 21, true
		Card c2 = new Card(Suit.Diamond, 10);
		assertTrue(player.addCard(c2));
		
		// sum > 21, false
		Card c3 = new Card(Suit.Spade, 13);
		assertFalse(player.addCard(c3));
	}

}
