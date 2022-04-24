import java.util.Random;

public class Card {
    private int value;
    private boolean faceUp;

    /**
     * Constructor that Creates a Card, with 1 as the associated value and face
     * down.
     */
    public Card() {
        value = 0;
        setFaceUp(false);
    }

    /**
     * Method that creates a random card
     *@return an integer value between 1 - 9
     */
    public int shuffle() {
        Random rand = new Random();
        value = rand.nextInt(10);
        return value;
    }

    /**
     * Method that will check if the card is face up or not
     * @return a boolean
     */
    public boolean isFaceUp() {
        return faceUp;
    }

    /**
     * Method that flips the card Once a card is turned face up, it remains face up
     * for the rest of the round
     */
    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    /**
     * Method that will view the value of the card.
     * @return a integer value of card if its face is turned upside.
     */
    public int viewCard() {
        if (faceUp)
            return value;
        else {
            System.out.println("Card face is down. Kindly invert.");
            return -1;
        }
    }

}
