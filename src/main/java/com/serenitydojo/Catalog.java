package com.serenitydojo;

import java.util.*;
import java.util.Map;
import static com.serenitydojo.Fruit.*;
public class Catalog {
    private Map<String, Double> fruitToPrice = Map.of(Apple.name(), 1.50, Banana.name(), 2.00, Pear.name(), 2.50, Orange.name(), 1.30);
    private List<CatalogItem> availableFruits = new ArrayList<>();

    public void setPriceOf(Fruit fruit, double price) {
        fruitToPrice.replace(fruit.name(), price);
    }

    public Map.Entry getPriceOf(Fruit fruit) {
        for (Map.Entry<String, Double> entry : fruitToPrice.entrySet()) {
            if (entry.getKey().equals(fruit.name())) {
                return entry;
            }
        }
        return null;
    }

    public static Catalog withItems(CatalogItem... catalogItems) {
        Catalog catalog = new Catalog();
        catalog.availableFruits.addAll(Arrays.asList(catalogItems));
        return catalog;
    }

    public List<CatalogItem> getAvailableFruits() {
            return availableFruits;
    }

    public boolean hasAvailable(Fruit fruit, int quantity) {
        for (CatalogItem item : availableFruits) {
            if (item.getFruit() == fruit && item.getQuantity() >= quantity) {
                return true;
            }
        }
        return false;
    }
}
