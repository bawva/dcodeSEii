
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class test {

    public static ArrayList<Double> AISto = new ArrayList<Double>();
    static int count = 0;

    public void stopZ() {

    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thisThread = Thread.currentThread();
                while (count < 10) {
                    System.out.println(count);
                    try {
                        if (count == 6) {
                            thisThread.interrupt();
                        }
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    count++;
                }
            }
        }).start();;
    }
}
