import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /** Set up a maven run profile in intellij or use maven from the command-line.
     Use the javafx:run argument to start the javafx application.
     Update all code and comments in this template to suit your own project.
     */

    public static Stage stage;

    @Override
    public void start(Stage stage) {

        Main.stage = stage;
        stage.setTitle("Higher or Lower");
        switchMainScene();
        stage.setMaximized(true);
        stage.show();
    }

    // Method that switches to the Home Screen
    public static void switchMainScene() {
        Scene mainScene = MainScene.createMainScene();
        stage.setScene(mainScene);
    }

    // Method that switches to the Character Selection Screen
    public static void switchCharacterScene() {
        Scene characterScene = CharacterScene.createCharacterScene();
        stage.setScene(characterScene);
    }

    // Method that switches to Burtle's game screen
    public static void switchGameScene(){
        Scene gameScene = GameScene.createGameScene();
        stage.setScene(gameScene);
    }

    // Method that switches to Poxie's game screen
    public static void switchGameScene2(){
        Scene gameScene2 = GameScene2.createGameScene();
        stage.setScene(gameScene2);
    }

    // Method that switches to Loppy's game screen
    public static void switchGameScene3(){
        Scene gameScene3 = GameScene3.createGameScene();
        stage.setScene(gameScene3);
    }
    public static void main(String[] args) {
        launch();
    }

}