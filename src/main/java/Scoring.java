import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Scoring {

    public static int score = 0;
    public static int incorrectGuesses = 0;

    /**
     * Methods that update the Burtle to be happy
     * @param imageview
     */
    public static void updateHappyBurtle(ImageView imageview) {
        Image happyBurtle = new Image("happyBurtle.png");
        imageview.setImage(happyBurtle);
    }

    /**
     * Methods that update the Poxie to be happy
      * @param imageview
     */
    public static void updateHappyPoxie(ImageView imageview) {
        Image happyPoxie = new Image("happyPoxie.png");
        imageview.setImage(happyPoxie);
    }

    /**
     * Methods that update the Loppy  to be happy
     * @param imageview
     */
    public static void updateHappyLoppy(ImageView imageview) {
        Image happyLoppy = new Image("happyLoppy.png");
        imageview.setImage(happyLoppy);
    }

    /**
     * Methods that update the Burtle to be sad
     * @param imageview
     */
    public static void updateSadBurtle(ImageView imageview) {
        Image sadBurtle = new Image("sadBurtle.png");
        imageview.setImage(sadBurtle);
    }

    /**
     * Methods that update the Poxie to be sad
     * @param imageview
     */
    public static void updateSadPoxie(ImageView imageview) {
        Image sadPoxie = new Image ("sadPoxie.png");
        imageview.setImage(sadPoxie);
    }

    /**
     * Methods that update the Loppy to be sad
     * @param imageview
     */
    public static void updateSadLoppy(ImageView imageview) {
        Image sadLoppy = new Image("sadLoppy.png");
        imageview.setImage(sadLoppy);
    }

    /**
     * Methods that update the Burtle to be neutral
     * @param imageview
     */
    public static void resetBurtle(ImageView imageview) {
        Image neutralBurtle = new Image("burtle.png");
        imageview.setImage(neutralBurtle);
    }

    /**
     *  Methods that update the Poxie to be neutral
     * @param imageview
     */
    public static void resetPoxie(ImageView imageview) {
        Image neutralPoxie = new Image("poxie.png");
        imageview.setImage(neutralPoxie);
    }

    /**
     * Methods that update the Loppy to be neutral
     * @param imageview
     */
    public static void resetLoppy(ImageView imageview) {
        Image neutralLoppy = new Image("loppy.png");
        imageview.setImage(neutralLoppy);
    }

    /**
     * Method that updates the text of a label
     * @param label
     * @param text
     * @param button
     * @param text2
     */
    public static void updateOpponentLabel(Label label, String text, Button button, String text2) {
        label.setText(text);
        button.setText(text2);
    }

    /**
     * Method that updates an imageview
     * @param imageview
     */
    public static void resetGame(ImageView imageview) {
        Card.unflipCard(imageview);
    }

    /**
     * Method that ends the game after three wrong guesses
     */
    public static void endGame(){
        var alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Game Over: ");
        alert.setHeaderText("You have guessed wrong too many times, and the game is over.");
        alert.setContentText("To replay this opponent, click Restart Game. \n \n To pick a new opponent, click New Opponent. \n \n To exit the program, click Exit Game. \n \n");

        //Button that exit the game
        ButtonType exit = new ButtonType("Exit Game");

        // Button that resets the game against the current opponent
        ButtonType resetGame = new ButtonType("Restart Game");

        // Button that goes back to opponent page
        ButtonType chooseCharacter = new ButtonType("New Opponent");

        // Button that closes the game
        alert.getButtonTypes().addAll(resetGame, chooseCharacter, exit);
        alert.showAndWait().ifPresent((btnType) -> {
            if(btnType == resetGame){
                score = 0;
                incorrectGuesses = 0;
            } else if (btnType == chooseCharacter) {
                score = 0;
                incorrectGuesses = 0;
                Main.switchCharacterScene();
            } else {
                Main.stage.close();
            }
        });
    }
}
