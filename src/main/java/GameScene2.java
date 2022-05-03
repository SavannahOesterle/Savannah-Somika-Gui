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

    public static int firstValue;
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

        Label currentScore = new Label ("Your current score is: " + Scoring.score);
        currentScore.setTextFill(Paint.valueOf("#0076a3"));
        currentScore.setFont(Font.font("Cambria", 24));
        currentScore.setVisible(false);

        Label guesses = new Label("Incorrect Guesses: ");
        guesses.setTextFill(Paint.valueOf("#0076a3"));
        guesses.setFont(Font.font("Cambria", 24));
        guesses.setVisible(false);

        Button startBtn = new Button ("Let's Go!");
        startBtn.setTextFill(Paint.valueOf("#0076a3"));
        startBtn.setFont(Font.font("Cambria", 24));

        Button resetBtn = new Button ("Play Again?");
        resetBtn.setTextFill(Paint.valueOf("#0076a3"));
        resetBtn.setFont(Font.font("Cambria", 24));
        resetBtn.setVisible(false);

        opponentMessage.getChildren().addAll(opponentName, startInstructions, currentScore, guesses, startBtn, resetBtn);
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

        // When the startBtn is pressed, it generates two card values, flips the first card, and updates the opponent's label to the card value
        startBtn.setOnAction(e -> {
            startBtn.setVisible(false);
            firstValue = Card.FirstCard();
            secondValue = Card.SecondCard(firstValue);
            Card.flipCard(firstCard, firstValue, firstCardValue);
            Scoring.updateOpponentLabel(startInstructions, "The first card is " + firstValue, null, null);
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

        // When the higher button is pressed, flips the second card and updates the score appropriately
        higherBtn.setOnAction(e -> {
            Card.flipCard(secondCard, secondValue, secondCardValue);
            secondCardValue.setVisible(true);
            currentScore.setVisible(true);
            resetBtn.setVisible(true);
            if(firstValue < secondValue) {
                Scoring.updateHappyPoxie(opponent);
                Scoring.updateOpponentLabel(startInstructions, "Good job!", startBtn, "Play Again?");
                Scoring.score += 1;
                Scoring.updateOpponentLabel(currentScore,"You have " + Scoring.score + " points!", null, null);
            } else {
                guesses.setVisible(true);
                Scoring.incorrectGuesses +=1;
                Scoring.updateSadPoxie(opponent);
                Scoring.updateOpponentLabel(startInstructions, "Better luck next time!", startBtn, "Play Again?");
                Scoring.updateOpponentLabel(guesses, "Incorrect Guesses: " + Scoring.incorrectGuesses, null, null);
                Scoring.updateOpponentLabel(currentScore,"You have " + Scoring.score + " points!", null, null);
            }
        });

        // When the lower button is pressed, flips the second card and updates the score appropriately
        lowerBtn.setOnAction(e -> {
            Card.flipCard(secondCard, secondValue, secondCardValue);
            secondCardValue.setVisible(true);
            currentScore.setVisible(true);
            resetBtn.setVisible(true);
            if(firstValue > secondValue) {
                Scoring.updateHappyPoxie(opponent);
                Scoring.updateOpponentLabel(startInstructions, "Good job!", startBtn, "Play Again?");
                Scoring.score += 1;
                Scoring.updateOpponentLabel(currentScore,"You have " + Scoring.score + " points!", null, null);
            } else {
                guesses.setVisible(true);
                Scoring.incorrectGuesses += 1;
                Scoring.updateSadPoxie(opponent);
                Scoring.updateOpponentLabel(startInstructions, "Better luck next time!", startBtn, "Play Again?");
                Scoring.updateOpponentLabel(guesses, "Incorrect Guesses: " + Scoring.incorrectGuesses, null, null);
                Scoring.updateOpponentLabel(currentScore,"You have " + Scoring.score + " points!", null, null);
            }

        });

        // When the resetBtn is pressed, it starts another round (same as startBtn)
        resetBtn.setOnAction(e -> {
            if (Scoring.incorrectGuesses < 3) {
                resetBtn.setVisible(false);
                currentScore.setVisible(false);
                guesses.setVisible(false);
                Scoring.resetPoxie(opponent);
                Scoring.resetGame(secondCard);
                secondCardValue.setVisible(false);
                firstValue = Card.FirstCard();
                secondValue = Card.SecondCard(firstValue);
                Card.flipCard(firstCard, firstValue, firstCardValue);
                Scoring.updateOpponentLabel(startInstructions, "The first card is " + firstValue, null, null);
            } else {
                Scoring.endGame();
            }
        });

        secondCardStack.getChildren().addAll(secondCard, secondCardValue);
        GridPane.setConstraints(secondCardStack, 2, 1);


        // Add everything to the grid
        gridpane.getChildren().addAll(opponent, opponentMessage, firstCardStack, vbox, secondCardStack);

        Scene gameScene = new Scene(new StackPane(gridpane), stage.getWidth(), stage.getHeight());
        return gameScene;
    }


}

