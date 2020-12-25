package m3javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IncDecButton extends Application 
{
	//instance data and controllers
	private Text counterText;
	private Button incButton, decButton;
	private int counter, interval;
	private TextField intervalField;
	private Label intervalLabel;
	
	public void start(Stage primaryStage)
	{
		// intializing instance data
		counter = 0;
		interval = 1;
		
		// Vbox for program
		VBox mainVBox = new VBox();
		mainVBox.setStyle("-fx-background-color: aquamarine ");
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setSpacing(10);
		
		//Counter 
		counterText = new Text("0");
		counterText.setFont(Font.font("Helvetica", 30));
		counterText.setFill(Color.BLACK);
		mainVBox.getChildren().add(counterText);
		
		incButton = new Button(" + ");
		incButton.setOnAction(this::handleIncrement);
		
		decButton = new Button(" - ");
		decButton.setOnAction(this::handleIncrement);
		
		//Hbox for buttons
		HBox buttonHBox = new HBox(decButton, incButton); 
		buttonHBox.setAlignment(Pos.CENTER);
		buttonHBox.setSpacing(12);
		mainVBox.getChildren().add(buttonHBox);
		
		// TextField for increment value
		intervalField = new TextField("1");
		intervalField.setMaxWidth(50);
		intervalField.setOnAction(this::handleIncrement);
		
		//Label for increment value text field
		intervalLabel = new Label("interval : ");
		intervalLabel.setFont(Font.font("Helvetica", 16));
		
		//Hbox for increment textField
		HBox intervalBox = new HBox(intervalLabel, intervalField);
		intervalBox.setAlignment(Pos.CENTER);
		mainVBox.getChildren().add(intervalBox);
		
		Scene scene = new Scene(mainVBox, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	private void handleIncrement(ActionEvent e)
	{
		interval = Integer.parseInt(intervalField.getText());

		// info contained inside ActionEvent object
		// if method is triggered by user of the text field if else wont change anything
		if( e.getSource() == incButton)
		{
			counter += interval;
		} else if(e.getSource() == decButton)
		{
			counter -= interval;
		}
		counterText.setText(String.valueOf(counter));
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}
