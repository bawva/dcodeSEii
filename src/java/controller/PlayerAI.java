
package controller;

import java.sql.ResultSet;
import m.JDBC;


public class PlayerAI {

    public void sell() {
        int current_turn = GameStatus.turn;
        double max = 0;
        int maxStock = 0;
        if (current_turn > 1) {
            for (int i = 0; i < PlayerAccount.buy.length; i++) {
                int stock1 = (int) PlayerAccount.buy[i][0];
                double price = PlayerAccount.buy[i][1];
                double price1 = 1;
                if (stock1 == 0) {
                    break;
                } else {
                    double lastValue = GameStatus.a1[stock1][current_turn - 1];
                    double currentValue = GameStatus.a1[stock1][current_turn];
                    double diff = currentValue - lastValue;
                    if (max < diff) {
                        PlayerAccount.sell[current_turn][0] = stock1;
                        PlayerAccount.sell[current_turn][1] = GameStatus.a1[stock1][current_turn];
                        PlayerAccount.acount_balance = +GameStatus.a1[stock1][current_turn];
                    }
                }
            }
        }
    }

    public void buy() {
        int current_turn = GameStatus.turn;
        double min = 0;
        int minStock = 0;
        if (current_turn > 0) {
            for (int i = 0; i < GameStatus.a1.length; i++) {
                double lastValue = GameStatus.a1[i][current_turn - 1];
                double currentValue = GameStatus.a1[i][current_turn];
                double diff = currentValue - lastValue;
                if (i == 0) {
                    min = GameStatus.a1[i][current_turn];
                }
                if (min > diff) {
                    min = diff;
                    minStock = i;
                }
                if (GameStatus.a1[minStock][current_turn] < PlayerAccount.acount_balance) {
                    PlayerAccount.buy[current_turn - 1][0] = minStock + 1;
                    PlayerAccount.buy[current_turn - 1][1] = GameStatus.a1[minStock][current_turn];
                    PlayerAccount.acount_balance = -GameStatus.a1[minStock][current_turn];
                }
            }

        }
    }
}
