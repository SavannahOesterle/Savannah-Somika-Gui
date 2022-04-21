import java.util.Random;

public class Card {

    private int value;
    private boolean faceUp;

    /**
     * Constructor that creates a random card
     * @return an integer value between 1 - 9
     */
    public int Card () {
        faceUp = false;

        Random rand = new Random();
        int value = rand.nextInt(10);
        return value;
    }

    /**
     * Method that flips the card
     * Once a card is turned face up, it remains face up for the rest of the round
     */
    public void flipCard(){
        faceUp = true;
    }

}
