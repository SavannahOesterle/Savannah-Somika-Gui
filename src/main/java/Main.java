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

    public static void switchGameScene2(){
        Scene gameScene2 = GameScene2.createGameScene();
        stage.setScene(gameScene2);
    }

    public static void switchGameScene3(){
        Scene gameScene3 = GameScene3.createGameScene();
        stage.setScene(gameScene3);
    }
    public static void main(String[] args) {
        launch();
    }

}