package blackjack;

public class Card {

	// One of four suits for this card
	private Suit mySuit;
	
	// Number of card, ace = 1..., jack-king = 11-13
	private int myNumber;
	
	public Card(Suit aSuit, int aNumber) {
		
		this.mySuit = aSuit;
		
		if (aNumber >= 1 && aNumber <= 13){
			this.myNumber = aNumber;
		} else {
			System.out.println(aNumber + " is not a valid cardnum");
		}
	}

	public int getMyNumber() {
		return myNumber;
	}
	
	public String toString() {
		
		String numString = "Problem";
		
		switch (this.myNumber) {
		
		case 1:
			numString = "Ace";
			break;
		case 2:
			numString = "Two";
			break;
		case 3:
			numString = "Three";
			break;
		case 4:
			numString = "Four";
			break;
		case 5:
			numString = "Five";
			break;
		case 6:
			numString = "Six";
			break;
		case 7:
			numString = "Seven";
			break;
		case 8:
			numString = "Eight";
			break;
		case 9:
			numString = "Nine";
			break;
		case 10:
			numString = "Ten";
			break;
		case 11:
			numString = "Jack";
			break;
		case 12: 
			numString = "Queen";
			break;
		case 13:
			numString = "King";
			break;
		}
		
		return numString + " of " + this.mySuit.toString();
	}
	

}
