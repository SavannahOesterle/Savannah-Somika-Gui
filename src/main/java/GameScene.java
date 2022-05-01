import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class GameScene extends Main {

    public static Scene createGameScene() {
        // Create a grid and add space between the cells
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setVgap(100);
        gridpane.setHgap(10);
        gridpane.setAlignment(Pos.CENTER);

        // Set the width of the three columns
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);

        // Title Label
        Label title = new Label("Higher or Lower");
        GridPane.setConstraints(title, 1, 0);
        title.setAlignment(Pos.BASELINE_CENTER);
        title.setFont(Font.font("Cambria", 64));
        title.setTextFill(Color.web("#0076a3"));

        // Placeholder for First Card
        StackPane firstCardHolder = new StackPane();

        Rectangle firstCard = new Rectangle();
        firstCard.setX(150);
        firstCard.setY(100);
        firstCard.setWidth(200);
        firstCard.setHeight(200);
        firstCard.setArcWidth(20);
        firstCard.setArcHeight(20);
        firstCard.setFill(Paint.valueOf("#0076a3"));

        Label firstCardLabel = new Label("?");
        firstCardLabel.setFont(Font.font("Cambria", 200));
        firstCardLabel.setTextFill(Color.web("fff"));
        firstCardLabel.setAlignment(Pos.CENTER);

        firstCardHolder.getChildren().addAll(firstCard, firstCardLabel);
        firstCardHolder.setAlignment(Pos.CENTER);
        GridPane.setConstraints(firstCardHolder, 0, 1);

        // Center Column with higher/lower buttons
        VBox vbox = new VBox(8);
        vbox.setAlignment(Pos.CENTER);
        Button higherBtn = new Button();
        higherBtn.setPrefHeight(80);
        higherBtn.setPrefWidth(80);
        higherBtn.setStyle("-fx-background-color: #0076a3; -fx-shape: 'M 0 0 50 0 0 50 z'");
        higherBtn.setRotate(45);

        Label buttonLabel = new Label("Higher or Lower?");
        buttonLabel.setFont(Font.font("Cambria", 24));
        buttonLabel.setTextFill(Color.web("#0076a3"));

        Button lowerBtn = new Button();
        lowerBtn.setPrefHeight(80);
        lowerBtn.setPrefWidth(80);
        lowerBtn.setStyle("-fx-background-color: #0076a3; -fx-shape: 'M 0 0 50 0 0 50 z'");
        lowerBtn.setRotate(225);

        vbox.getChildren().addAll(higherBtn, buttonLabel, lowerBtn);
        GridPane.setConstraints(vbox, 1, 1);

        // Placeholder for Second Card
        StackPane secondCardHolder = new StackPane();

        Rectangle secondCard = new Rectangle();
        secondCard.setX(150);
        secondCard.setY(100);
        secondCard.setWidth(200);
        secondCard.setHeight(200);
        secondCard.setArcWidth(20);
        secondCard.setArcHeight(20);
        secondCard.setFill(Paint.valueOf("#0076a3"));

        Label secondCardLabel = new Label("?");
        secondCardLabel.setFont(Font.font("Cambria", 200));
        secondCardLabel.setTextFill(Color.web("fff"));
        secondCardLabel.setAlignment(Pos.CENTER);

        secondCardHolder.getChildren().addAll(secondCard, secondCardLabel);
        secondCardHolder.setAlignment(Pos.CENTER);
        GridPane.setConstraints(secondCardHolder, 2, 1);

        //Score Labels at bottom
        Label currentScore = new Label("Current Score: ");
        GridPane.setConstraints(currentScore, 0, 2);
        currentScore.setFont(Font.font("Cambria", 32));
        currentScore.setTextFill(Color.web("#0076a3"));
        currentScore.setAlignment(Pos.BASELINE_LEFT);

        Label highScore = new Label("High Score: ");
        GridPane.setConstraints(highScore, 2, 2);
        highScore.setFont(Font.font("Cambria", 32));
        highScore.setTextFill(Color.web("#0076a3"));
        highScore.setAlignment(Pos.BASELINE_LEFT);

        // Add everything to the grid
        gridpane.getChildren().addAll(title, firstCardHolder, vbox, secondCardHolder, currentScore, highScore);

        Scene gameScene = new Scene(new StackPane(gridpane), 640, 480);
        return gameScene;
    }
}

