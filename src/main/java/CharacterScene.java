import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CharacterScene extends Main {

    public static Scene createCharacterScene() {

        // Create a grid and add space between the cells
        GridPane characterGrid = new GridPane();
        characterGrid.setPadding(new Insets(10, 10, 10, 10));
        characterGrid.setVgap(50);
        characterGrid.setHgap(50);
        characterGrid.setAlignment(Pos.CENTER);

        // Set the width of the three columns
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33);


        // Set the height of the four rows
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(25);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(25);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(25);

        // Prompt Label
        Label prompt = new Label("Pick an Opponent: ");
        prompt.setAlignment(Pos.CENTER);
        prompt.setFont(Font.font("Cambria", 64));
        prompt.setTextFill(Color.web("#0076a3"));
        GridPane.setConstraints(prompt, 0, 0);

        // First Opponent Option
        Image firstOpponent = new Image("burtle.png");
        ImageView firstCharacter = new ImageView(firstOpponent);
        firstCharacter.setFitWidth(300);
        firstCharacter.setFitHeight(300);
        firstCharacter.setPreserveRatio(true);

        GridPane.setConstraints(firstCharacter, 0, 1);


        // Button to Choose First Character and Start Game
        Button firstCharacterName = new Button("Burtle");
        firstCharacterName.setStyle("-fx-text-fill: #0076a3; -fx-font-size:18;");
        firstCharacterName.setAlignment(Pos.CENTER);
        firstCharacterName.setOnAction( e -> Main.switchGameScene());

        GridPane.setConstraints(firstCharacterName, 0, 2);

        // Imageview for second character
        Image secondOpponent = new Image("poxie.png");
        ImageView secondCharacter = new ImageView(secondOpponent);
        secondCharacter.setFitWidth(300);
        secondCharacter.setFitHeight(300);
        secondCharacter.setPreserveRatio(true);

        GridPane.setConstraints(secondCharacter, 1, 1);

        // Button for second character
        Button secondCharacterName = new Button("Poxie");
        secondCharacterName.setStyle("-fx-text-fill: #0076a3; -fx-font-size:18;");
        secondCharacterName.setOnAction( e -> Main.switchGameScene2());
        secondCharacterName.setAlignment(Pos.CENTER);

        GridPane.setConstraints(secondCharacterName, 1, 2);

        // Imageview for third character
        Image thirdOpponent = new Image("loppy.png");
        ImageView thirdCharacter = new ImageView(thirdOpponent);
        thirdCharacter.setFitWidth(300);
        thirdCharacter.setFitHeight(300);
        thirdCharacter.setPreserveRatio(true);

        GridPane.setConstraints(thirdCharacter, 2, 1);

        // Button for third character
        Button thirdCharacterName = new Button("Loppy");
        thirdCharacterName.setStyle("-fx-text-fill: #0076a3; -fx-font-size:18;");
        thirdCharacterName.setAlignment(Pos.CENTER);
        thirdCharacterName.setOnAction( e -> Main.switchGameScene3());

        GridPane.setConstraints(thirdCharacterName, 2, 2);


        // Add everything to the grid
        characterGrid.getChildren().addAll(prompt, firstCharacter, firstCharacterName, secondCharacter, secondCharacterName, thirdCharacter, thirdCharacterName);

        Scene characterScene = new Scene(new StackPane(characterGrid), stage.getWidth(), stage.getHeight());
        return characterScene;

    }
}
