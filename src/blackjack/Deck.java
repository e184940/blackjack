package blackjack;

import java.util.Random;
import java.util.ArrayList;

public class Deck {
	
	// arraylist of cards, top card = first index
	private ArrayList<Card> myCards;
	
	// number of cards in deck
	private int numCards;
	
	public Deck() {
		// call other constructor, default: 1 deck, no shuffle
		this(1, false);
	}
	
	
	/**
	 * constructor for deck
	 * 
	 * @param numDecks how many decks in this deck
	 * @param shuffle  whether deck(s) should be shuffled
	 */
	public Deck(int numDecks, boolean shuffle) {
		
		myCards = new ArrayList<>();
		this.numCards = numDecks * 52;
		
		// fill the deck with specified number of decks
		
		// for each deck, suit, and number
		for (int d = 0; d < numDecks; d++) {
			for (int s = 0; s < 4; s++) {
				for (int n = 1; n <= 13; n++) {
					// adds new card to deck using enumvalues, 
					// suit index s, and number index n
					myCards.add(new Card(Suit.values()[s], n));
				}
			}
		}
		
		// shuffle upon request
		if (shuffle) {
			shuffleDeck();
		}
	}

	// shuffle deck (Fisher-Yates algo)
	public void shuffleDeck() {
		
		// intialize random num generator
		Random rng = new Random();
		
		// temp card
		Card temp;
		
		int j;
		for (int i = 0; i < this.numCards; i++) {
			
			// get random index j
			j = rng.nextInt(this.numCards);
			
			// good ol variable swap
			temp = myCards.get(i);
			myCards.set(i, myCards.get(j));
			myCards.set(j, temp);
		}
	}
	
	public Card dealCard() {
		
		// gets card first in arraylist
		Card top = myCards.get(0);
		
		// remove drawn card from deck
		myCards.remove(top);
		
		return top;
	}

}
