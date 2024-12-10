package LF05;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    private static final int LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain;
        do {
            playAgain = playGame();
        } while (playAgain);
        System.out.println("Danke fürs Spielen!");
    }

    private static boolean playGame() {
        String secretNumber = generateSecretNumber();
        System.out.println("Willkommen bei MasterMind!");
        System.out.println("Versuche, die 4-stellige Zahl zu erraten (Ziffern von 0 bis 9, keine Wiederholungen).");

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Versuch " + attempt + ": Geben Sie Ihre Zahl ein: ");
            String guess = scanner.nextLine();

            if (!isValidGuess(guess)) {
                System.out.println("Ungültiger Versuch. Stellen Sie sicher, dass Ihre Eingabe 4 verschiedene Ziffern enthält.");
                attempt--; // Zähle diesen Versuch nicht
                continue;
            }

            int[] result = evaluateGuess(secretNumber, guess);
            int fullHits = result[0];
            int hits = result[1];

            if (fullHits == LENGTH) {
                System.out.println("Herzlichen Glückwunsch! Sie haben die Zahl " + secretNumber + " erraten!");
                System.out.println("Sie haben " + attempt + " Versuche benötigt.");
                return askPlayAgain();
            } else {
                System.out.println(fullHits + " Volltreffer, " + hits + " Treffer.");
            }
        }

        System.out.println("Leider haben Sie die Zahl " + secretNumber + " nicht erraten. Viel Glück beim nächsten Mal!");
        return askPlayAgain();
    }

    private static String generateSecretNumber() {
        HashSet<Integer> digits = new HashSet<>();
        StringBuilder secret = new StringBuilder();

        while (secret.length() < LENGTH) {
            int digit = random.nextInt(10);
            if (digits.add(digit)) {
                secret.append(digit);
            }
        }

        return secret.toString();
    }

    private static boolean isValidGuess(String guess) {
        if (guess.length() != LENGTH) {
            return false;
        }
        HashSet<Character> uniqueDigits = new HashSet<>();
        for (char c : guess.toCharArray()) {
            if (!Character.isDigit(c) || !uniqueDigits.add(c)) {
                return false;
            }
        }
        return true;
    }

    private static int[] evaluateGuess(String secret, String guess) {
        int fullHits = 0;
        int hits = 0;
        boolean[] secretUsed = new boolean[LENGTH];
        boolean[] guessUsed = new boolean[LENGTH];

        // Überprüfen auf Volltreffer
        for (int i = 0; i < LENGTH; i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                fullHits++;
                secretUsed[i] = true;
                guessUsed[i] = true;
            }
        }

        // Überprüfen auf Treffer
        for (int i = 0; i < LENGTH; i++) {
            if (!guessUsed[i]) {
                for (int j = 0; j < LENGTH; j++) {
                    if (!secretUsed[j] && guess.charAt(i) == secret.charAt(j)) {
                        hits++;
                        secretUsed[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[]{fullHits, hits};
    }

    private static boolean askPlayAgain() {
        System.out.print("Möchten Sie noch einmal spielen? (j/n): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("j");
    }
}
