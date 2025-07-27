package GUI;

import blackjack.Card;
import blackjack.Deck;
import blackjack.Hand;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class BlackjackController {
	
	@FXML private HBox dBox;
	@FXML private HBox pBox;
	@FXML private Text pHandSum;
	@FXML private Text dHandSum;
	@FXML private Text statusText;
	@FXML private Button hitButton;
	@FXML private Button stayButton;
	
	private Deck deck;
	private Hand pHand;
	private Hand dHand;
	
	@FXML
	public void initialize() {

		
		hitButton.setOnAction(e -> {
			boolean stillPlaying = pHand.addCard(deck.dealCard());
			updateUI(false);
			if(!stillPlaying) {
				endGame();
			}
		});
		
		stayButton.setOnAction(e -> {
			while (dHand.getSum() < 17) {
				dHand.addCard(deck.dealCard());
			}
			endGame();
		});
	}
	
	private void endGame() {

		updateUI(true);
		hitButton.setDisable(true);
		stayButton.setDisable(true);
		
		int pSum = pHand.getSum();
		int dSum = dHand.getSum();
		
		if (pSum > dSum && pSum <= 21 || dSum > 21) {
			statusText.setText("Player wins!");
		} else if (dSum > pSum && dSum <= 21 || pSum > 21) {
			statusText.setText("Dealer wins!");
		} else {
			statusText.setText("Its a tie!");
		}
	}

	private void updateUI(boolean showDealerCards) {

		pBox.getChildren().clear();
		dBox.getChildren().clear();
		
		for (int i = 0; i < dHand.getMyCards().size(); i++) {
			ImageView cardView;
			
			if(i == 0 && !showDealerCards) {
				Image backImage = new Image(getClass().getResourceAsStream("/cards/BACK.png"));
				cardView = new ImageView(backImage);
			} else {
				Card card = dHand.getMyCards().get(i);
				Image cardImage = new Image(getClass().getResourceAsStream("/cards/" + card.getImageFileName()));
				cardView = new ImageView(cardImage);
			}
			
			cardView.setFitHeight(100);
			cardView.setPreserveRatio(true);
			dBox.getChildren().add(cardView);
		}
		
		for (Card c : pHand.getMyCards()) {
			Image cardImage = new Image(getClass().getResourceAsStream("/cards/" + c.getImageFileName()));
			ImageView cardView = new ImageView(cardImage);
			
			cardView.setFitHeight(100);
			cardView.setPreserveRatio(true);
			pBox.getChildren().add(cardView);
		}
		
		pHandSum.setText("Players sum: " + pHand.getSum());
		if(showDealerCards) {
			dHandSum.setText("Dealers sum: " + dHand.getSum());
		} else {
			int visVal = dHand.getMyCards().get(1).getValue();
			dHandSum.setText("Dealers sum: " + visVal + " + ?");
		}
	}

	public void setupGame(int numDecks, boolean shuffle) {
		
		deck = new Deck(numDecks, shuffle);
		pHand = new Hand("Player");
		dHand = new Hand("Dealer");
		
		pHand.addCard(deck.dealCard());
		dHand.addCard(deck.dealCard());
		pHand.addCard(deck.dealCard());
		dHand.addCard(deck.dealCard());
		
		updateUI(false);
	}


}
