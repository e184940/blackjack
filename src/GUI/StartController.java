package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartController {

	@FXML private Spinner<Integer> deckSpinner;
	@FXML private CheckBox shuffleCheckBox;
	@FXML private Button startButton;

	@FXML
	public void initialize() {
		deckSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 5));
		startButton.setOnAction(this::handleStartButton);
	}


	@FXML
	private void handleStartButton(ActionEvent event) {
		try {
			int numDecks = deckSpinner.getValue();
			boolean shuffle = shuffleCheckBox.isSelected();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/blackjack.fxml"));
			Parent root = loader.load();

			BlackjackController controller = loader.getController();
			controller.setupGame(numDecks, shuffle);

			Stage currentStage = (Stage) startButton.getScene().getWindow();
			Scene startScene = currentStage.getScene();
			
			Scene gameScene = new Scene(root, startScene.getWidth(), startScene.getHeight());
			
			currentStage.setScene(gameScene);
			currentStage.setTitle("Blackjack Game");
			currentStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
