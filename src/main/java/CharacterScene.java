import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CharacterScene {

    public static Scene createCharacterScene() {

        // Create a grid and add space between the cells
        GridPane characterGrid = new GridPane();
        characterGrid.setPadding(new Insets(10, 10, 10, 10));
        characterGrid.setVgap(100);
        characterGrid.setHgap(10);
        characterGrid.setAlignment(Pos.CENTER);

        // Set the width of the three columns
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33);

        // Prompt Label
        Label prompt = new Label("Pick a Character: ");
        prompt.setAlignment(Pos.CENTER);
        prompt.setFont(Font.font("Cambria", 64));
        prompt.setTextFill(Color.web("#0076a3"));
        GridPane.setConstraints(prompt, 0, 0);

        // First Opponent Option
        VBox firstCharacterStack = new VBox();
        Image firstOpponent = new Image("firstOpponent.png");
        ImageView firstCharacter = new ImageView(firstOpponent);
        firstCharacter.setFitWidth(300);
        firstCharacter.setFitHeight(300);
        firstCharacter.setPreserveRatio(true);


        // Button to Choose First Character and Start Game
        Button firstCharacterName = new Button("Burtle");
        firstCharacterName.setAlignment(Pos.CENTER);
        firstCharacterName.setOnAction( e -> Main.switchGameScene());

        firstCharacterStack.getChildren().addAll(firstCharacter, firstCharacterName);
        firstCharacterStack.setAlignment(Pos.CENTER);
        GridPane.setConstraints(firstCharacterStack, 1, 1);

        // Placeholder for second character
        StackPane secondCharacterStack = new StackPane();
        ImageView secondCharacter = new ImageView(firstOpponent);
        secondCharacter.setFitWidth(300);
        secondCharacter.setFitHeight(300);
        secondCharacter.setPreserveRatio(true);

        Button secondCharacterName = new Button("Burtle");
        secondCharacterName.setOnAction( e -> Main.switchGameScene());
        secondCharacterName.setAlignment(Pos.CENTER);

        secondCharacterStack.getChildren().addAll(secondCharacter, secondCharacterName);
        secondCharacterStack.setAlignment(Pos.CENTER);
        GridPane.setConstraints(secondCharacterStack, 2, 1);

        //Placeholder for third character
        StackPane thirdCharacterStack = new StackPane();
        ImageView thirdCharacter = new ImageView(firstOpponent);
        thirdCharacter.setFitWidth(300);
        thirdCharacter.setFitHeight(300);
        thirdCharacter.setPreserveRatio(true);


        Button thirdCharacterName = new Button("Burtle");
        thirdCharacterName.setAlignment(Pos.CENTER);
        thirdCharacterName.setOnAction( e -> Main.switchGameScene());

        secondCharacterStack.getChildren().addAll(thirdCharacter, thirdCharacterName);
        thirdCharacterStack.setAlignment(Pos.CENTER);
        GridPane.setConstraints(thirdCharacterStack, 3, 1);


        // Add everything to the grid
        characterGrid.getChildren().addAll(prompt, firstCharacterStack, secondCharacterStack, thirdCharacterStack);

        Scene characterScene = new Scene(new StackPane(characterGrid), 640, 480);
        return characterScene;

    }
}
