package blackjack;

public class Card {

	// One of four suits for this card
	private Suit mySuit;

	// Number of card, ace = 1/11..., jack-king = 10-13
	private int myNumber;

	public Card(Suit aSuit, int aRank) {

		this.mySuit = aSuit;

		if (aRank >= 1 && aRank <= 13) {
			this.myNumber = aRank;
		} else {
			System.out.println(aRank + " is not a valid cardNum");
		}
	}

	public int getMyNumber() {
		return myNumber;
	}

	public Suit getMySuit() {
		return mySuit;
	}
	
	public String getImageFileName() {
		return getRankCode() + "-" + getSuitCode() +".png";
	}

	private String getRankCode() {

		return switch (myNumber) {
		case 1 -> "A";
		case 11 -> "J";
		case 12 -> "Q";
		case 13 -> "K";
		default -> String.valueOf(myNumber);
		};

	}
	
	private String getSuitCode() {
		return switch(mySuit) {
		case Club -> "C";
		case Diamond -> "D";
		case Heart -> "H";
		case Spade -> "S";
		};
	}
	
	@Override
	public String toString() {
		return getRankCode() + " of " + mySuit.toString();
	}

	public int getValue() {
		if (myNumber > 10) {
			return 10; // face cards
		} else if (myNumber == 1) {
			return 11; // ace
		} else {
			return myNumber; // regular cards
		}
	}
	
}
