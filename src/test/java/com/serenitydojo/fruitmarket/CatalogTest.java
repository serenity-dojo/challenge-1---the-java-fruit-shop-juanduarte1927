package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.CatalogItem;
import org.junit.Test;
import java.util.List;
import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {

        Catalog catalog = new Catalog();
        catalog.setPriceOf(Apple, 4.00);
        catalog.setPriceOf(Orange, 5.50);
        catalog.setPriceOf(Banana, 6.00);
        catalog.setPriceOf(Pear, 4.50);
        assertThat(catalog.getPriceOf(Apple).getValue()).isEqualTo(4.00);
        assertThat(catalog.getPriceOf(Orange).getValue()).isEqualTo(5.50);
        assertThat(catalog.getPriceOf(Banana).getValue()).isEqualTo(6.00);
        assertThat(catalog.getPriceOf(Pear).getValue()).isEqualTo(4.50);
    }

    @Test
    public void shouldListAvailableFruitsAlphabetically() {
         Catalog catalog = Catalog.withItems(
                 new CatalogItem(Pear, 1),
                 new CatalogItem(Apple, 1),
                 new CatalogItem(Banana, 1)
         );
         List<CatalogItem> availableFruits = catalog.getAvailableFruits();
         assertThat(availableFruits.get(0).getFruit()).isEqualTo(Apple);
         assertThat(availableFruits.get(1).getFruit()).isEqualTo(Banana);
         assertThat(availableFruits.get(2).getFruit()).isEqualTo(Pear);
    }

    @Test
    public void shouldReportPriceOfGivenFruit() {
        Catalog catalog = new Catalog();
        assertThat(catalog.getPriceOf(Apple).getValue()).isEqualTo(1.50);
        assertThat(catalog.getPriceOf(Orange).getValue()).isEqualTo(1.30);
        assertThat(catalog.getPriceOf(Banana).getValue()).isEqualTo(2.00);
        assertThat(catalog.getPriceOf(Pear).getValue()).isEqualTo(2.50);

    }

    @Test
    public void shouldAddFruitsToCart() {
        Catalog catalog = new Catalog();
        assertThat(catalog.getPriceOf(Apple).getValue()).isEqualTo(1.50);
        assertThat(catalog.getPriceOf(Orange).getValue()).isEqualTo(1.30);
        assertThat(catalog.getPriceOf(Banana).getValue()).isEqualTo(2.00);
        assertThat(catalog.getPriceOf(Pear).getValue()).isEqualTo(2.50);
    }
}
