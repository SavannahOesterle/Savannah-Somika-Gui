import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
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
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);

        // Title Label
        Label title = new Label("Higher or Lower");
        GridPane.setConstraints(title, 1, 0);
        title.setAlignment(Pos.CENTER);
        title.setFont(Font.font("Cambria", 64));
        title.setTextFill(Color.web("#0076a3"));

        // Placeholder for first character
        StackPane firstCharacterStack = new StackPane();

        Rectangle firstCharacter = new Rectangle();
        firstCharacter.setX(150);
        firstCharacter.setY(100);
        firstCharacter.setWidth(200);
        firstCharacter.setHeight(200);
        firstCharacter.setArcWidth(20);
        firstCharacter.setArcHeight(20);
        firstCharacter.setFill(Paint.valueOf("#0076a3"));

        Button firstCharacterName = new Button("Lucy");

        firstCharacterStack.getChildren().addAll(firstCharacter, firstCharacterName);
        GridPane.setConstraints(firstCharacterStack, 0, 1);

        // Placeholder for second character
        StackPane secondCharacterStack = new StackPane();

        Rectangle secondCharacter = new Rectangle();
        secondCharacter.setX(150);
        secondCharacter.setY(100);
        secondCharacter.setWidth(200);
        secondCharacter.setHeight(200);
        secondCharacter.setArcWidth(20);
        secondCharacter.setArcHeight(20);
        secondCharacter.setFill(Paint.valueOf("#0076a3"));


        Button secondCharacterName = new Button("Ellie");
        secondCharacterStack.getChildren().addAll(secondCharacter, secondCharacterName);
        GridPane.setConstraints(secondCharacterStack, 1, 1);

        //Placeholder for third character
        StackPane thirdCharacterStack = new StackPane();

        Rectangle thirdCharacter = new Rectangle();
        thirdCharacter.setX(150);
        thirdCharacter.setY(100);
        thirdCharacter.setWidth(200);
        thirdCharacter.setHeight(200);
        thirdCharacter.setArcWidth(20);
        thirdCharacter.setArcHeight(20);
        thirdCharacter.setFill(Paint.valueOf("#0076a3"));

        Button thirdCharacterName = new Button("Ellie");
        secondCharacterStack.getChildren().addAll(secondCharacter, secondCharacterName);
        GridPane.setConstraints(thirdCharacterStack, 2, 1);

        // Bottom Prompt Label
        Label bottomPrompt = new Label("Higher or Lower");
        GridPane.setConstraints(title, 1, 2);
        bottomPrompt.setAlignment(Pos.CENTER);
        bottomPrompt.setFont(Font.font("Cambria", 32));
        bottomPrompt.setTextFill(Color.web("#0076a3"));

        characterGrid.getChildren().addAll(title, firstCharacterStack, secondCharacterStack, thirdCharacterStack, bottomPrompt);

        Scene characterScene = new Scene(new StackPane(characterGrid), 640, 480);
        return characterScene;

    }
}
