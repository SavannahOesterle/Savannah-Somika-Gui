import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Card {

    /**
     * Constructor that creates the first card
     * @return a random value between 0 - 9
     */
    public static int FirstCard() {
        Random rand = new Random();
        int value = rand.nextInt(10);
        return value;
    }

    /**
     * Constructor that creates the second card, based off of the value of the second card
     * @param value
     * @return a random value between 0 - 9 and != to the first card
     */
    public static int SecondCard(int value) {
        Random rand = new Random();
        int secondValue = rand.nextInt(10);
        if (secondValue == value) {
            while (secondValue == value) {
                secondValue = rand.nextInt(10);
            }
        }
        return secondValue;
    }

    /**
     * Method that flips the card
     * @param imageview to be updated
     * @param value to be placed on card
     * @param label to be updated
     */
    public static void flipCard(ImageView imageview, int value, Label label) {
        Image flippedCard = new Image("FlippedCard.png");
        imageview.setImage(flippedCard);
        label.setText ((String.valueOf(value)));
    }

    // Method that resets the second card
    public static void unflipCard(ImageView imageview) {
        Image unflippedCard = new Image("Unflipped.png");
        imageview.setImage(unflippedCard);
    }

}
