package LF05.fussball;

import java.util.Random;

public class Gameplay {

    private static final Random rnd = new Random();

    private static final int gameDuration = 90;
    private static final int maxExtenderDuration = 5;
    private static final int nextActionDelayMax = 10;

    public static void doGame(Spiel game) throws GameBreakException {
        int time = rnd.nextInt(1,nextActionDelayMax+1);;
        do {
            if (rnd.nextInt(1,51) == 1) throw new GameBreakException(time,"Wetter");
            Mannschaft attackingTeam = actionSide(game.getHeimmannschaft(),game.getGastmannschaft());
            Spieler attackingPlayer = randomPlayer(attackingTeam);
            if (attainGoal(attackingPlayer,getOpposingTeam(attackingTeam,game).getTorwart())) {
                game.getHistory().addEvent("Minute " + time + ": "+"TOOOR! " + attackingPlayer.getName()
                        + " hat ein Tor gegen " + getOpposingTeam(attackingTeam,game).getName()
                        + " geschossen!");
                if (isGuest(attackingTeam,game)) {
                    game.getErgebnis().gastGoal();
                } else {
                    game.getErgebnis().heimGoal();
                }
                attackingPlayer.addGoal();
            } else {
                game.getHistory().addEvent("Minute " + time + ": "+"Gehaltener Ball von "
                        + getOpposingTeam(attackingTeam,game).getTorwart().getName()
                        + "!");
            }
            time += rnd.nextInt(0,nextActionDelayMax+1);
        } while (time <= (gameDuration+rnd.nextInt(0,maxExtenderDuration+1)));
        String outcome = null;
        if (game.getErgebnis().getGastmannschaft() == game.getErgebnis().getHeimmannschaft()) {
            outcome = "Unentschieden zwischen " + game.getGastmannschaft().getName() + " und " + game.getHeimmannschaft().getName();
        } else if (game.getErgebnis().getGastmannschaft() > game.getErgebnis().getHeimmannschaft()) {
            outcome = "Sieg von "+ game.getGastmannschaft().getName() + " gegen " + game.getHeimmannschaft().getName();
        } else if (game.getErgebnis().getGastmannschaft() < game.getErgebnis().getHeimmannschaft()) {
            outcome = "Sieg von "+ game.getHeimmannschaft().getName() + " gegen " + game.getGastmannschaft().getName();
        }
        game.getHistory().br();
        game.getHistory().addEvent("Das Spiel ist mit einem "+outcome+" ausgegangen.");
    }

    private static Mannschaft actionSide(Mannschaft heim, Mannschaft gast) {
        final int sum = determineMotivation(gast) + determineMotivation(heim);
        if (rnd.nextInt(0,sum) > determineMotivation(heim)) {
            return gast;
        } else {
            return heim;
        }
    }

    private static boolean isGuest(Mannschaft team, Spiel game) {
        return team == game.getGastmannschaft();
    }

    private static Mannschaft getOpposingTeam(Mannschaft team, Spiel game) {
        if (game.getGastmannschaft() == team) {
            return game.getHeimmannschaft();
        }
        return game.getGastmannschaft();
    }

    private static Spieler randomPlayer(Mannschaft team) {
        return team.getPlayerList().get(rnd.nextInt(0,team.getPlayerList().size()));
    }

    private static int determineMotivation(Mannschaft team) {
        int ret = team.getMotivation();
        if (ret < 1) {
            ret = 1;
        }
        return ret;
    }

    private static boolean attainGoal(Spieler player, Torwart keeper) {
        int power = player.getTorschuss() + rnd.nextInt(-2,2);
        if (power < 1) {
            power = 1;
        }
        return power > keeper.getReaktion();
    }
}
