
package controller;


public class getStockValues {

    public int getStock() {
        int stock = 0;
        ValueChangeAlgorithm vca = new ValueChangeAlgorithm();
        int i = vca.getGeneralTrendMarketComponent() + vca.getRandomMarketComponent() + vca.getSectorTrendMarketComponent();
        if (i > 0) {
            stock = i;
        }
//        System.out.println(stock);
        return stock;
    }
}
