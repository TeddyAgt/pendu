import com.teddy.game.GuessGame;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        final Random random = new Random();
        final String[] words = "voiture maison ordinateur programmation".split(" ");
        String wordToGuess = words[random.nextInt(words.length)];
        GuessGame game = new GuessGame(wordToGuess, 10);

        System.out.println("Début du jeu du pendu !");

        while(true) {
            System.out.println(game);
            final char letter = getLetter("Entrez une lettre:");

            game.guessLetter(letter);

            if (game.isLost()) {
                System.out.println(game);
                System.out.println("Perdu !");
            } else if (game.isWon()) {
                System.out.println(game);
                System.out.println("Gagné !");
            }

            if (game.isLost() || game.isWon()) {
                char replayAnswer = getLetter("Voulez-vous rejouer ? o/n");
                if (replayAnswer == 'o') {
                    wordToGuess = words[random.nextInt(words.length)];
                    game = new GuessGame(wordToGuess, 10);
                } else {
                    break;
                }
            }
        }
    }

    private static char getLetter(String message) {
        final Scanner playerInput = new Scanner(System.in);
        Character letter = null;

        do {
            System.out.println(message);
            String input = playerInput.nextLine();
            if (input.length() == 1) {
                letter = input.charAt(0);
            }
        } while (letter == null);

        return letter;
    }
}