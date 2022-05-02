import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Scoring {

    public static int score = 0;

    // Methods that update the characters to be happy
    public static void updateHappyBurtle(ImageView imageview) {
        Image happyBurtle = new Image("happyBurtle.png");
        imageview.setImage(happyBurtle);
    }

    public static void updateHappyPoxie(ImageView imageview) {
        Image happyPoxie = new Image("happyPoxie.png");
        imageview.setImage(happyPoxie);
    }

    public static void updateHappyLoppy(ImageView imageview) {
        Image happyLoppy = new Image("happyLoppy.png");
        imageview.setImage(happyLoppy);
    }

    // Methods that update the characters to be sad
    public static void updateSadBurtle(ImageView imageview) {
        Image sadBurtle = new Image("sadBurtle.png");
        imageview.setImage(sadBurtle);
    }

    public static void updateSadPoxie(ImageView imageview) {
        Image sadPoxie = new Image ("sadPoxie.png");
        imageview.setImage(sadPoxie);
    }

    public static void updateSadLoppy(ImageView imageview) {
        Image sadLoppy = new Image("sadLoppy.png");
        imageview.setImage(sadLoppy);
    }

    // Methods that update the characters to be neutral
    public static void resetBurtle(ImageView imageview) {
        Image neutralBurtle = new Image("burtle.png");
        imageview.setImage(neutralBurtle);
    }

    public static void resetPoxie(ImageView imageview) {
        Image neutralPoxie = new Image("poxie.png");
        imageview.setImage(neutralPoxie);
    }

    public static void resetLoppy(ImageView imageview) {
        Image neutralLoppy = new Image("loppy.png");
        imageview.setImage(neutralLoppy);
    }
    public static void updateOpponentLabel(Label label, String text, Button button, String text2) {
        label.setText(text);
        button.setText(text2);
    }

    public static void resetGame(ImageView imageview) {
        Card.unflipCard(imageview);
    }

}
