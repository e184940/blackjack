package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EndController {

	@FXML
	private Button settingsButton;
	@FXML
	private Button replayButton;
	@FXML
	private Button quitButton;

	private int numDeck;
	private boolean shuffle;

	public void setGameParams(int numDeck, boolean shuffle) {
		this.numDeck = numDeck;
		this.shuffle = shuffle;
	}

	@FXML
	public void initialize() {
		settingsButton.setOnAction(e -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/start.fxml"));
				Parent root = loader.load();

				Stage stage = (Stage) settingsButton.getScene().getWindow();
				Scene currentScene = stage.getScene();
				Scene startScene = new Scene(root, currentScene.getWidth(), currentScene.getHeight());

				stage.setScene(startScene);
				stage.setTitle("Blackjack");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		replayButton.setOnAction(e -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/blackjack.fxml"));
				Parent root = loader.load();
				
				BlackjackController controller = loader.getController();
				controller.setupGame(numDeck, shuffle);

				Stage stage = (Stage) replayButton.getScene().getWindow();
				Scene currentScene = stage.getScene();
				Scene blackjackScene = new Scene(root, currentScene.getWidth(), currentScene.getHeight());

				stage.setScene(blackjackScene);
				stage.setTitle("Blackjack Game");
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		
		quitButton.setOnAction(e -> {
			Stage stage = (Stage) quitButton.getScene().getWindow();
			stage.close();
		});
	}

}
