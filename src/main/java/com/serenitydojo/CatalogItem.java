package com.serenitydojo;

public class CatalogItem {

    private final Fruit fruit;
    private final int quantity;

    public CatalogItem(Fruit fruit, int quantity) {

        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
