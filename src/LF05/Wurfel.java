package LF05;

import static util.IO.*;

public class Wurfel {

    public static void main(String[] args){
        eingabe();
    }

    static void eingabe(){
        int numExp = getInteger("Wie viele Experimente?\n");
        int numWur = getInteger("Wie viele Würfe pro Experiment?\n");

        int[][] experiments = exp(numExp, numWur);

        auswertung(experiments);
    }

    static int[][] exp(int numExp, int numWur){
        int[][] experiments = new int[numExp][numWur];

        for (int i = 0; i < numExp; i++) {
            for (int j = 0; j < numWur; j++) {

                experiments[i][j] = (int) (Math.random() * 6) + 1;
            }
        }

        return experiments;
    }

    static void auswertung(int[][] experiments){
    int[][] sums = new int[experiments.length][1];
    for(int i = 0; i < experiments.length;i++){
        int sum = 0;

        for(int j = 0; j < experiments[i].length; j++){
            sum += experiments[i][j];
        }
        sums[i][0] = sum;
        System.out.println("Experiment " + (i+1) + ": Summe = " + sums[i][0]);
    }

    }
}