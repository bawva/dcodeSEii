
package controller;

import java.util.Random;


public class ValueChangeAlgorithm {

    public int getRandomMarketComponent() {
        Random rand = new Random();
        int value = rand.nextInt((2 - (-2)) + 1) - 2;
        return value;
    }

    public int getSectorTrendMarketComponent() {
        Random rand = new Random();
        int value = rand.nextInt((3 - (-3)) + 1) - 3;
        return value;
    }

    public int getGeneralTrendMarketComponent() {
        Random rand = new Random();
        int value = rand.nextInt((3 - (-3)) + 1) - 3;
        return value;
    }

}
