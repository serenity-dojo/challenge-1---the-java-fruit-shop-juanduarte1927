package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;
public class ShopppingCart {
    private List<CatalogItem> addedFruits = new ArrayList<>();

    public static ShopppingCart addItems(Catalog catalog, CatalogItem... catalogItems) {
        ShopppingCart shopppingCart = new ShopppingCart();
        for (CatalogItem item : catalogItems) {
            if (catalog.hasAvailable(item.getFruit(), item.getQuantity())) {
                shopppingCart.addedFruits.add(item);
            } else {
                throw new RuntimeException("There are not enough fruits in the store.");
            }
        }
        return shopppingCart;
    }

    public Double totalBuy(List<CatalogItem> addedFruits) {
        Catalog catalog = new Catalog();
        double totalPrice = 0.00;
        Double discount = 0.10;

        for (CatalogItem cart: addedFruits) {
             Double unitPrice = (Double) catalog.getPriceOf(cart.getFruit()).getValue();
             if(cart.getQuantity() >= 5){
                 Double subtotal = cart.getQuantity() * unitPrice;
                 Double appliedDiscount = subtotal * discount;
                 totalPrice += subtotal - appliedDiscount;
             } else {
                 totalPrice += cart.getQuantity() * unitPrice;
            }
        }
        return totalPrice;
    }
    public List<CatalogItem> getAvailableFruits() {
            return addedFruits;
    }
}
