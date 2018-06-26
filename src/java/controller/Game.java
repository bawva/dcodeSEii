
package controller;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import m.JDBC;


public class Game {
    
    private static Game game;
    
    public static double[][] stock_value = new double[12][1];
    public static int[] eventArray = new int[4];
    static boolean b = false;
    static int tu = 1;
    
    public static void init() {
        GameStatus.gameStatus = 1;
        int count = 0;
        try {
            ResultSet stockResult = new JDBC().getData("select * from stock_values");
            while (stockResult.next()) {
                stock_value[count][0] = stockResult.getDouble(4);
                count++;
            }
            EventProbabiolity ep = new EventProbabiolity();
            ep.SelectEvent();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < 10; i++) {
            getStockValues sv = new getStockValues();
            int ii = 0;
            if (eventArray[1] == i || b) {
                ii = eventArray[0];
                b = true;
                if (eventArray[2] == tu) {
                    b = false;
                }
            }
            if (i == 0) {
                GameStatus.a1[0][i] = stock_value[0][0] + sv.getStock() + ii;
                GameStatus.a1[1][i] = stock_value[1][0] + sv.getStock() + ii;
                GameStatus.a1[2][i] = stock_value[2][0] + sv.getStock() + ii;
                GameStatus.a1[3][i] = stock_value[3][0] + sv.getStock() + ii;
                GameStatus.a1[4][i] = stock_value[4][0] + sv.getStock() + ii;
                GameStatus.a1[5][i] = stock_value[5][0] + sv.getStock() + ii;
                GameStatus.a1[6][i] = stock_value[6][0] + sv.getStock() + ii;
                GameStatus.a1[7][i] = stock_value[7][0] + sv.getStock() + ii;
                GameStatus.a1[8][i] = stock_value[8][0] + sv.getStock() + ii;
                GameStatus.a1[9][i] = stock_value[9][0] + sv.getStock() + ii;
                GameStatus.a1[10][i] = stock_value[10][0] + sv.getStock() + ii;
                GameStatus.a1[11][i] = stock_value[11][0] + sv.getStock() + ii;
            } else {
                GameStatus.a1[0][i] = GameStatus.a1[0][i - 1] + sv.getStock() + ii;
                GameStatus.a1[1][i] = GameStatus.a1[1][i - 1] + sv.getStock() + ii;
                GameStatus.a1[2][i] = GameStatus.a1[2][i - 1] + sv.getStock() + ii;
                GameStatus.a1[3][i] = GameStatus.a1[3][i - 1] + sv.getStock() + ii;
                GameStatus.a1[4][i] = GameStatus.a1[4][i - 1] + sv.getStock() + ii;
                GameStatus.a1[5][i] = GameStatus.a1[5][i - 1] + sv.getStock() + ii;
                GameStatus.a1[6][i] = GameStatus.a1[6][i - 1] + sv.getStock() + ii;
                GameStatus.a1[7][i] = GameStatus.a1[7][i - 1] + sv.getStock() + ii;
                GameStatus.a1[8][i] = GameStatus.a1[8][i - 1] + sv.getStock() + ii;
                GameStatus.a1[9][i] = GameStatus.a1[9][i - 1] + sv.getStock() + ii;
                GameStatus.a1[10][i] = GameStatus.a1[10][i - 1] + sv.getStock() + ii;
                GameStatus.a1[11][i] = GameStatus.a1[11][i - 1] + sv.getStock() + ii;
            }
        }
        
    }
    
    public void startGame() {
        if (GameStatus.turn == 0) {
            init();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    GameStatus.turn = i;
                    PlayerAI pi = new PlayerAI();
                    pi.buy();
                    pi.sell();
                    try {
                        Thread.sleep(4000);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }
    
    public static Game getInstance() {
        if (game == null) {
            game = new Game();
//            System.out.println("creating game");
        } else {
//            System.out.println("retun existing");
        }
        return game;
    }
}
