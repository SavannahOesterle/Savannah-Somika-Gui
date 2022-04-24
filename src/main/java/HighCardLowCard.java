import java.util.Scanner;

public class HighCardLowCard {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("ACNH High Card Low Card Game");
        System.out.println("You will be shown a card with a number from 0-9.");
        System.out.println("You will then be shown a second card.");
        System.out.println("Guess if the second card is higher or lower than the first.");
        System.out.println("If you guess correctly, you will earn a point.");
        System.out.println("If you guess incorrectly, you will lose a point.");
        System.out.println("The game is over when you reach 5 points or 0 points");

        System.out.println("**********************************************************");
        System.out.println("*********************Game Begins Now**********************");
        System.out.println("**********************************************************");

        int points = 0; // Player 1 Points


        while (points < GameConstants.WIN_POINTS && points < GameConstants.LOSE_POINTS ) {

            Card c1 = new Card();
            int card1 = c1.shuffle();
            c1.setFaceUp(true); // enabling flag to view Card 1.
            System.out.println("Card 1 Value : " + c1.viewCard());

            Card c2 = new Card();
            int card2 = c2.shuffle();
            System.out.println("Please Press Higher or Lower to Predict if Card 2 is Higher or Lower than Card 1");
            String guess = input.next();

            if (guess.equalsIgnoreCase(GameConstants.HIGHER) && card2 > card1) {
                points++;
                c2.setFaceUp(true); // enabling flag to view Card 2.
                System.out.println("Card 1 value is : " + c1.viewCard() + " and Card 2 value is : " + c2.viewCard());
                System.out.println("Correct Prediction...you earn a point.");

            } else if (guess.equalsIgnoreCase(GameConstants.LOWER) && card2 < card1) {
                points++;
                c2.setFaceUp(true); // enabling flag to view Card 2.
                System.out.println("Card 1 value is : " + c1.viewCard() + " and Card 2 value is : " + c2.viewCard());
                System.out.println("Correct Prediction...you earn a point.");

            } else if (guess.equalsIgnoreCase(GameConstants.HIGHER) && card2 < card1) {
                points--;
                c2.setFaceUp(true); // enabling flag to view Card 2.
                System.out.println("Card 1 value is : " + c1.viewCard() + " and Card 2 value is : " + c2.viewCard());
                System.out.println("Incorrect Prediction...you lose a point.");

            } else if (guess.equalsIgnoreCase(GameConstants.LOWER) && card2 > card1) {
                points--;
                c2.setFaceUp(true); // enabling flag to view Card 2.
                System.out.println("Card 1value is : " + c1.viewCard() + " and Card 2 value is : " + c2.viewCard());
                System.out.println("Incorrect Prediction...you lose a point.");

            } else if (guess.equalsIgnoreCase(GameConstants.LOWER)
                    || guess.equalsIgnoreCase(GameConstants.HIGHER) && card1 == card2) {
                c2.setFaceUp(true); // enabling flag to view Card 2.
                System.out.println("Card 1 value is : " + c1.viewCard() + " and Card 2 value is : " + c2.viewCard());
                System.out.println("Flip again because its a draw !!! ");

            } else {
                System.out.println("Invalid Choice");

            }

            System.out.println("Current Score : " + points );
            System.out.println("**********************Next Iteration**********************");

        }

        input.close();

        if (points == GameConstants.WIN_POINTS) {
            System.out.println("You Won !!!");

        } else if (points == GameConstants.LOSE_POINTS) {
            System.out.println("You lose !!!");
        }

        System.out.println("**********************************************************");
        System.out.println("************************Game Over*************************");
        System.out.println("**********************************************************");

    }
}


