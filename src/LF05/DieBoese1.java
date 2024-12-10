package LF05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DieBoese1 {
    private static final int WINNING_SCORE = 100; // Zielpunktzahl
    private List<Player> players;
    private int currentPlayerIndex;
    private Scanner scanner;
    private Random random;

    public DieBoese1() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
        random = new Random();
        currentPlayerIndex = 0;
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void playGame() {
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("Es ist " + currentPlayer.getName() + "'s Zug.");
            playTurn(currentPlayer);

            if (currentPlayer.getScore() >= WINNING_SCORE) {
                System.out.println(currentPlayer.getName() + " hat das Spiel gewonnen!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    private void playTurn(Player player) {
        int roundScore = 0;
        boolean continueRolling = true;

        while (continueRolling) {
            int roll = rollDice();
            System.out.println(player.getName() + " würfelt: " + roll);

            if (roll == 1) {
                System.out.println("Oh nein! " + player.getName() + " hat eine 1 geworfen. Punkte dieser Runde gehen verloren.");
                roundScore = 0;
                break;
            } else {
                roundScore += roll;
                System.out.println(player.getName() + " hat " + roundScore + " Punkte in dieser Runde.");

                if (roundScore >= 11) {
                    System.out.println("Möchte " + player.getName() + " weitermachen oder Punkte sichern? (continue/safe)");
                    String decision = scanner.nextLine().trim().toLowerCase();

                    if (decision.equals("safe")) {
                        player.addScore(roundScore);
                        System.out.println(player.getName() + " sichert sich " + roundScore + " Punkte.");
                        break;
                    }
                }
            }
        }
    }

    private int rollDice() {
        return random.nextInt(6) + 1; // Würfel von 1 bis 6
    }

    public static void main(String[] args) {
        DieBoese1 game = new DieBoese1();
        game.addPlayer("Spieler 1");
        game.addPlayer("Spieler 2");


        game.playGame();
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }
}