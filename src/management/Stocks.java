package management;

import java.util.HashMap;
import java.util.Map;

public class Stocks {
    private Map<String, Integer> stocks = new HashMap<>() ;

    public void setStocks(String ingredient, Integer quantite) {
        stocks.put(ingredient, quantite);
    }
    public void stocksUtilise(String ingredient, Integer quantite) {
        stocks.put(ingredient, quantite);
    }
    public void stocksConsomme(String ingredient, Integer quantite) {
        stocks.put(ingredient, quantite);
    }
}
