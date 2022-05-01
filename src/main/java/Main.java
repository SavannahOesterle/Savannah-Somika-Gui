import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /** Set up a maven run profile in intellij or use maven from the command-line.
     Use the javafx:run argument to start the javafx application.
     Update all code and comments in this template to suit your own project.
     */

    private static Stage stage;

    @Override
    public void start(Stage stage) {

        Main.stage = stage;
        stage.setTitle("Higher or Lower");
        switchMainScene();
        stage.show();
    }

    public static void switchMainScene() {
        Scene mainScene = MainScene.createMainScene();
        stage.setScene(mainScene);
    }

    public static void switchCharacterScene() {
        Scene characterScene = CharacterScene.createCharacterScene();
        stage.setScene(characterScene);
    }

    public static void switchGameScene(){
        Scene gameScene = GameScene.createGameScene();
        stage.setScene(gameScene);
    }
    public static void main(String[] args) {
        launch();
    }

}