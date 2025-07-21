package blackjack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Deck deck = new Deck(1, true);
		
		// initialize players
		Player player = new Player("Egor");
		Player dealer = new Player("Dealer");
		
		player.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		player.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		
		// print initial hans
		System.out.println("Dealt cards");
		player.printHand(true);
		dealer.printHand(false);
		
		// player done / dealer done
		boolean pDone = false;
		boolean dDone = false;
		String ans;
		
		// gameloop
		while (!pDone || !dDone) {
			
			// player
			if (!pDone) {
				
				System.out.println();
				System.out.print("Hit or stay? (h/s): ");
				ans = scanner.next();
				System.out.println();
				
				if (ans.compareToIgnoreCase("H") == 0) {
					pDone = !player.addCard(deck.dealCard());
					player.printHand(true);
				} else {
					pDone = true;
				}
			}
			
			// dealer
			if (!dDone) {
				
				if (dealer.getSum() < 17) {
					System.out.println("Dealer hits");
					dDone = !dealer.addCard(deck.dealCard());
					dealer.printHand(false);
				} else {
					System.out.println("Dealer stays");
					dDone = true;
				}
			}
			
			System.out.println();
		}
		
		scanner.close();
		
		// print final hans
		player.printHand(true);
		dealer.printHand(true);
		
		int pSum = player.getSum();
		int dSum = dealer.getSum();
		
		System.out.println();
		if (pSum > dSum && pSum <= 21 || dSum > 21) {
			System.out.println("Player wins!");
		} else if (dSum > pSum && dSum <= 21 || pSum > 21) {
			System.out.println("Dealer wins!");
		} else {
			System.out.println("Its a tie!");
		}
	}

}
