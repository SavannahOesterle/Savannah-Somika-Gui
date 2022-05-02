import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class GameScene2 extends Main {

    public static int secondValue;

    public static Scene createGameScene() {

        // Create a grid and add space between the cells
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        gridpane.setAlignment(Pos.CENTER);

        // Set the width of the three columns
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(60);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);

        // Set the height of the three rows
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(30) ;
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(40);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(30) ;


        // ImageView for opponent (center column)
        ImageView opponent = new ImageView();
        opponent.setFitHeight(400);
        opponent.setFitWidth(300);
        opponent.setPreserveRatio(true);

        Image poxieImage = new Image("poxie.png");
        //Image loppyImage = new Image("loppy.png");

        opponent.setImage(poxieImage);
        GridPane.setConstraints(opponent, 1, 0);

        // Vbox with Opponent's Text
        VBox opponentMessage = new VBox(10);


        Label opponentName = new Label("Poxie: ");
        opponentName.setTextFill(Paint.valueOf("#0076a3"));
        opponentName.setFont(Font.font("Cambria", 24));

        Label startInstructions = new Label ("Are you ready to start?");
        startInstructions.setTextFill(Paint.valueOf("#0076a3"));
        startInstructions.setFont(Font.font("Cambria", 24));

        Button startBtn = new Button ("Let's Go!");
        startBtn.setTextFill(Paint.valueOf("#0076a3"));
        startBtn.setFont(Font.font("Cambria", 24));

        opponentMessage.getChildren().addAll(opponentName, startInstructions, startBtn);
        opponentMessage.setAlignment(Pos.CENTER_LEFT);
        GridPane.setConstraints(opponentMessage, 2, 0);

        // StackPane for first card
        StackPane firstCardStack = new StackPane();

        Image unflippedCard = new Image("unflipped.png");
        ImageView firstCard = new ImageView(unflippedCard);
        firstCard.setFitHeight(800);
        firstCard.setFitWidth(800);
        firstCard.setPreserveRatio(true);

        Label firstCardValue = new Label();
        firstCardValue.setTextFill(Color.web("#0076a3"));
        firstCardValue.setAlignment(Pos.CENTER_LEFT);
        firstCardValue.setFont(Font.font("Cambria", 72));

        startBtn.setOnAction(e -> {
            int firstValue = Card.FirstCard();
            secondValue = Card.SecondCard(firstValue);
            Card.flipCard(firstCard, firstValue, firstCardValue);
        });

        firstCardStack.getChildren().addAll(firstCard, firstCardValue);
        GridPane.setConstraints(firstCardStack, 0, 1);

        // Center Column with higher/lower buttons
        VBox vbox = new VBox(12);
        vbox.setAlignment(Pos.CENTER);
        Button higherBtn = new Button("Higher");
        higherBtn.setPrefHeight(40);
        higherBtn.setMinWidth(150);

        Label buttonLabel = new Label("or");
        buttonLabel.setFont(Font.font("Cambria", 24));
        buttonLabel.setTextFill(Color.web("#0076a3"));

        Button lowerBtn = new Button("Lower");
        lowerBtn.setPrefHeight(40);
        lowerBtn.setMinWidth(150);

        vbox.getChildren().addAll(higherBtn, buttonLabel, lowerBtn);
        GridPane.setConstraints(vbox, 1, 1);


        // StackPane for second card
        StackPane secondCardStack = new StackPane();

        Image flippedCard = new Image("unflipped.png");
        ImageView secondCard = new ImageView(flippedCard);
        secondCard.setFitHeight(800);
        secondCard.setFitWidth(800);
        secondCard.setPreserveRatio(true);

        Label secondCardValue = new Label();
        secondCardValue.setTextFill(Color.web("#0076a3"));
        secondCardValue.setAlignment(Pos.CENTER_LEFT);
        secondCardValue.setFont(Font.font("Cambria", 72));


        higherBtn.setOnAction(e -> Card.flipCard(secondCard, secondValue, secondCardValue));

        lowerBtn.setOnAction(e -> Card.flipCard(secondCard, secondValue, secondCardValue));

        secondCardStack.getChildren().addAll(secondCard, secondCardValue);
        GridPane.setConstraints(secondCardStack, 2, 1);


        // Add everything to the grid
        gridpane.getChildren().addAll(opponent, opponentMessage, firstCardStack, vbox, secondCardStack);

        Scene gameScene = new Scene(new StackPane(gridpane), stage.getWidth(), stage.getHeight());
        return gameScene;
    }


}

