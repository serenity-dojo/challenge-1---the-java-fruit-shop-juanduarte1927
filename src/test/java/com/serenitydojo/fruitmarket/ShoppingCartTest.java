package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.CatalogItem;
import com.serenitydojo.ShopppingCart;
import org.junit.Test;

import java.util.List;

import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {
    @Test
    public void shouldAddFruitsToCart() {
        Catalog catalog = Catalog.withItems(
                new CatalogItem(Pear, 20),
                new CatalogItem(Apple, 20),
                new CatalogItem(Banana, 20)
        );

        ShopppingCart shoppingCart = ShopppingCart.addItems(catalog,
                new CatalogItem( Pear, 2),
                new CatalogItem( Apple, 3),
                new CatalogItem( Banana, 4)
        );

        List<CatalogItem> addedFruits = shoppingCart.getAvailableFruits();
        ShopppingCart cart = new ShopppingCart();
        Double total;
        total = cart.totalBuy(addedFruits);
        assertThat(total).isEqualTo(17.50);
    }
    @Test
    public void shouldApplyDiscountToBuy() {
        Catalog catalog = Catalog.withItems(
                new CatalogItem(Pear, 20),
                new CatalogItem(Apple, 20),
                new CatalogItem(Banana, 20)
        );

        ShopppingCart shoppingCart = ShopppingCart.addItems(catalog,
                new CatalogItem(Pear, 5),
                new CatalogItem(Apple, 20),
                new CatalogItem(Banana, 15)
        );

        List<CatalogItem> addedFruits = shoppingCart.getAvailableFruits();
        ShopppingCart cart = new ShopppingCart();
        Double total;
        total = cart.totalBuy(addedFruits);
        assertThat(total).isEqualTo(65.25);
    }
}
