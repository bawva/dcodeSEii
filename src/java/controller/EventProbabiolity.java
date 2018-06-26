
package controller;

import java.util.Random;


public class EventProbabiolity {

    public String SelectEvent() {
        String event = null;
        Random rand = new Random();
        double val = rand.nextDouble();
        if (val < 0.33) { // <-- 1/4 of the time.
            Game.eventArray[0] = 1;
            getSector();
            getDuration(5);
            getStart(2, 5);
        } else { // <-- 3/4 of the time.]
            Game.eventArray[0] = 2;
            getStart(2, 5);
            getStock();
            getDuration(3);
        }
        return event;
    }

    public void getSector() {
        Random rand = new Random();
        Events e = new Events();
        double val = rand.nextDouble();
        if (val < 0.5) { // <-- 1/4 of the time.
            Game.eventArray[0] = e.getBoom();
        } else { // <-- 3/4 of the time.]
            Game.eventArray[0] = e.getBust();
        }
    }

    public void getStock() {
        Random rand = new Random();
        Events e = new Events();
        double val = rand.nextDouble();
        if (val < 0.5) {
            selectStock();
        } else {
            Game.eventArray[0] = e.getTakeOver();
        }
    }

    public void selectStock() {
        Random rand = new Random();
        Events e = new Events();
        double val = rand.nextDouble();
        if (val < 0.5) { // <-- 1/4 of the time.
            Game.eventArray[0] = e.getProfitWarning();
        } else { // <-- 3/4 of the time.]
            Game.eventArray[0] = e.getScandal();
        }
    }

    public void getStart(int firstValue, int lastValue) {
        Random rand = new Random();
        int value = rand.nextInt((lastValue - (firstValue)) + 1) - firstValue;
        Game.eventArray[1] = value;
    }

    public void getDuration(int val) {
        Random rand = new Random();
        int value = rand.nextInt(val + 1);
        Game.eventArray[2] = value;
    }
}
