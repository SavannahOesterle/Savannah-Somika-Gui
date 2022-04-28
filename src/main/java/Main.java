import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

    /** Set up a maven run profile in intellij or use maven from the command-line.
     Use the javafx:run argument to start the javafx application.
     Update all code and comments in this template to suit your own project.
     */

    private static Stage stage;
    private Scene mainScene = MainScene.createMainScene();

    @Override
    public void start(Stage stage) {

        Main.stage = stage;
        stage.setTitle("Higher or Lower");
        switchScenes(mainScene);
        stage.show();



    }

    public static void switchScenes(Scene scene) {
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }

}