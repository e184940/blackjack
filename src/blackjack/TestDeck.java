package blackjack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDeck {
	
	private Deck deck;
	
	@BeforeEach
	void setUpDeck() {
		deck = new Deck();
	}
	
	@Test
	void testShuffle() {
				
		ArrayList<Card> orgOrder = new ArrayList<>(deck.getMyCards());
		
		deck.shuffleDeck();
		
		ArrayList<Card> shfOrder = deck.getMyCards();
		
		assertNotEquals(orgOrder, shfOrder);
		assertTrue(orgOrder.containsAll(shfOrder));
		assertTrue(shfOrder.containsAll(orgOrder));
	}
	
	@Test
	void testDeal() {
		
		int orgSize = deck.getMyCards().size();
		
		Card dealtCard = deck.dealCard();
		
		assertEquals(orgSize - 1, deck.getMyCards().size());
		assertFalse(deck.getMyCards().contains(dealtCard));
		
	}

}
