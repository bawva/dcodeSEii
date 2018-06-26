
package controller;

import java.util.Random;


public class Events {

    public int getBoom() {
        Random rand = new Random();
        int value = rand.nextInt((5 - (-1)) + 1) + 1;
        return value;
    }

    public int getBust() {
        Random rand = new Random();
        int value = rand.nextInt((5 - (5)) + 1) - 1;
        return value;
    }

    public int getProfitWarning() {
        Random rand = new Random();
        int value = rand.nextInt((3 - (2)) + 1) +2;
        return value;
    }

    public int getTakeOver() {
        Random rand = new Random();
        int value = rand.nextInt((-1 - (-5)) + 1) - 5;
        return value;
    }

    public int getScandal() {
        Random rand = new Random();
        int value = rand.nextInt((-3 - (-6)) + 1) - 6;
        return value;
    }

}
