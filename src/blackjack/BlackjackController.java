package blackjack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class BlackjackController {
	
	@FXML private HBox dBox;
	@FXML private HBox pBox;
	@FXML private Text statusText;
	@FXML private Button hitButton;
	@FXML private Button stayButton;
	
	private Deck deck;
	private Hand pHand;
	private Hand dHand;
	
	@FXML
	public void initialize() {
		
		deck = new Deck(8, true);
		pHand = new Hand("Player");
		dHand = new Hand("Dealer");
		
		pHand.addCard(deck.dealCard());
		dHand.addCard(deck.dealCard());
		pHand.addCard(deck.dealCard());
		dHand.addCard(deck.dealCard());
		
		updateUI(false);
		
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
			if(i == 0 && !showDealerCards) {
				dBox.getChildren().add(new Label("Hidden"));
			} else {
				dBox.getChildren().add(new Label(dHand.getMyCards().get(i).toString()));
			}
		}
		
		for (Card c : pHand.getMyCards()) {
			pBox.getChildren().add(new Label(c.toString()));
		}
	}

}
