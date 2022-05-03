import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainScene extends Main {

    public static Scene createMainScene() {
        // Create a grid and add space between the cells
        GridPane mainGrid = new GridPane();
        mainGrid.setPadding(new Insets(10, 10, 10, 10));
        mainGrid.setVgap(100);
        mainGrid.setHgap(10);
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setStyle("-fx-background-color: #0076a3;");

        // Title Label
        Label title = new Label("Higher or Lower");
        GridPane.setConstraints(title, 1, 0);
        title.setAlignment(Pos.CENTER);
        title.setFont(Font.font("Cambria", 64));
        title.setTextFill(Color.web("#FFFFFF"));

        // Center Column with Buttons
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefWidth(200);

        Button playBtn = new Button("Play Game");
        playBtn.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #0076a3; -fx-font-size:14;");
        playBtn.setMinWidth(vbox.getPrefWidth());
        playBtn.setMinHeight(50);

        playBtn.setOnAction( e -> {
            System.out.println("HI");
            Main.switchCharacterScene();
        });


        // Button to Display the Rules
        Button rulesBtn = new Button("Rules");
        rulesBtn.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #0076a3; -fx-font-size:14;");
        rulesBtn.setMinWidth(vbox.getPrefWidth());
        rulesBtn.setMinHeight(50);

        rulesBtn.setOnAction(e -> {
            var rulesAlert = new Alert(Alert.AlertType.INFORMATION);
            rulesAlert.setTitle("Higher or Lower Rules");
            rulesAlert.setHeaderText("How to Play: ");
            rulesAlert.setContentText("""
                    There are two cards, both randomly selected and containing values between 0 and 9.\s
                    \s
                    The first card will be revealed at the start of the game. You will have to guess if the hidden card is higher or lower than the first card\s
                    \s
                    The game ends if you guess incorrectly three times.\s
                    \s
                     Good luck!""");
            rulesAlert.showAndWait();
        });


        vbox.getChildren().addAll(playBtn, rulesBtn);
        GridPane.setConstraints(vbox, 1, 1);


        // Add everything to the grid
        mainGrid.getChildren().addAll(title, vbox);
        Scene mainScene = new Scene(new StackPane(mainGrid), stage.getHeight(),stage.getHeight());
        return mainScene;
    }
}
