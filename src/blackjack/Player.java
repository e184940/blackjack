package blackjack;

import java.util.ArrayList;

public class Player {
	
	private String name;
	
	private ArrayList<Card> hand;
	
	private int numCards;
	
	public Player(String aName) {
		this.name = aName;
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

	public int getSum() {
		
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		// calculate each cards contr to the handSum
		for (int c = 0; c < this.numCards; c++) {
			
			// get number of current card
			cardNum = this.hand.get(c).getMyNumber();
			
			// ace
			if (cardNum == 1) {
				numAces++;
				handSum += 11;
			// face cards
			} else if (cardNum > 10) {
				handSum += 10;
			// regular cards
			} else {
				handSum += cardNum;
			}
		}
		
		// adjust for aces if handSum > 21
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
		
		return handSum;
	}
	
	public void printHand(boolean showFirstCard) {

		System.out.println();
		System.out.println(this.name + "'s hand: ");
		
		for(int c = 0; c < this.numCards; c++) {
			if (c == 0 && !showFirstCard) {
				System.out.println("Hidden card");
			} else {
				System.out.println(this.hand.get(c).toString());
			}
		}
	}

}
