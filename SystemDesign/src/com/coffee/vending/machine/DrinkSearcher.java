package com.coffee.vending.machine;

import java.util.Collection;

public class DrinkSearcher extends Searcher<String, Drink> {
    public DrinkSearcher(final Collection<? extends Drink> drinks) {
        super(Drink::getName, drinks);
    }
}