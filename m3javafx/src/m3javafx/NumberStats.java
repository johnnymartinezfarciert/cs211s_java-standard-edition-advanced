package m3javafx;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NumberStats extends Application 
{
	private Text numberFieldLabel, resultText;
	private TextField numberField;
	private Button calculateButton, clearButton;
	
	private ArrayList<Integer> numberList;
	
	public void start(Stage primaryStage)
	{
		numberList = new ArrayList<Integer>();
		
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-background-color: aquamarine blue");
		
		numberFieldLabel = new Text("Enter a number:");
		numberField = new TextField();
		
		TilePane numberPane = new TilePane(numberFieldLabel, numberField);
		gridPane.add(numberPane, 0, 0);
		
		Scene scene = new Scene(gridPane, 200, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
