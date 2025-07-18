package blackjack;

import java.util.ArrayList;

public class Player {
	
	private String name;
	
	private ArrayList<Card> hand;
	
	private int numCards;
	
	public Player(String aName) {
		this.name = name;
		this.hand = new ArrayList<Card>();
		this.numCards = 0;
	}
	
	// whether the sum of new hand is +/- 21
	public boolean addCard(Card aCard) {
		
		if (this.numCards < 5) {
			this.hand.add(aCard);
			this.numCards++;
		}
		
		return this.getSum() <= 21;
		
	}

	// TODO
	private int getSum() {
		int sum;
		return 0;
	}

}
