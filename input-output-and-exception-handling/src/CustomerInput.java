import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class CustomerInput extends Application {

	private Stage primaryStage;
	private Text statusText, resultText;
	private Button uploadButton;

	private final static Font RESULT_FONT = Font.font("Helvetica", 24);
	private final static Font INPUT_FONT = Font.font("Helvetica", 20);

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		VBox primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(20);
		primaryBox.setStyle("-fx-background-color: white");

		VBox uploadBox = new VBox();
		uploadBox.setAlignment(Pos.CENTER);
		uploadBox.setSpacing(20);
		Text uploadLabel = new Text("Upload a comma-separated file with customer data.");
		uploadLabel.setFont(INPUT_FONT);
		uploadButton = new Button("Upload data");
		uploadButton.setOnAction(this::processDataUpload);

		uploadBox.getChildren().add(uploadLabel);
		uploadBox.getChildren().add(uploadButton);
		primaryBox.getChildren().add(uploadBox);

		VBox resultsBox = new VBox();
		resultsBox.setAlignment(Pos.CENTER);
		resultsBox.setSpacing(20);
		statusText = new Text("");
		statusText.setVisible(false);
		statusText.setFont(RESULT_FONT);
		statusText.setFill(Color.RED);
		resultText = new Text("");
		resultText.setVisible(false);
		resultText.setFont(RESULT_FONT);
		resultsBox.getChildren().add(statusText);
		resultsBox.getChildren().add(resultText);
		primaryBox.getChildren().add(resultsBox);

		Scene scene = new Scene(primaryBox, 475, 200, Color.TRANSPARENT);
		primaryStage.setTitle("Customer Data Upload");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void processDataUpload(ActionEvent event) {
		statusText.setVisible(false);
		resultText.setVisible(false);
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(primaryStage);
		parseFile(file);

	}

	private void parseFile(File file) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		String token = "";
		Scanner fileScan = null;
		int totalNumberOfOrders = 0;
		// reading contents from file
		try {
			fileScan = new Scanner(new FileInputStream(file));
			while (fileScan.hasNext()) {
				String line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				// parse the id name
				token = lineScan.next();
				String id = token;
				if (!id.matches("[A-Za-z\\s]*")) { // regex for at least one letter, or white space..
					throw new InvalidIDException();
				}

				// parse the number of orders
				token = lineScan.next();
				int numberOfOrders = Integer.parseInt(token);

				Customer customer = new Customer(id, numberOfOrders);
				customerList.add(customer);
			}
			for (Customer customer : customerList) {
				totalNumberOfOrders += customer.getNumberOfOrders();
			}

			// Update GUI display
			statusText.setText("Success added " + customerList.size() + " new customers");
			statusText.setVisible(true);
			resultText.setText("Total number of orders : " + totalNumberOfOrders);
			resultText.setVisible(true);
			// disable button
			uploadButton.setDisable(true);

		} catch (InvalidIDException ex) {
			statusText.setText("Invaid id field: " + token);
			statusText.setVisible(true);
		} catch (IOException ex) {
			statusText.setText("IO error file not found");
			statusText.setVisible(true);
		} catch (NumberFormatException ex) {
			statusText.setText("numberOfOrders field : " + token);
			statusText.setVisible(true);
		} finally {
			if (fileScan != null) {
				fileScan.close();
			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

	public class InvalidIDException extends Exception {
		private static final String MESSAGE = "Invalid id field";

		public InvalidIDException() {
			super(MESSAGE);
		}

		public InvalidIDException(String message) {
			super(MESSAGE);
		}
	}// end exception class

}