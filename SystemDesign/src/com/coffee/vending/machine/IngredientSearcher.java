package com.coffee.vending.machine;

import java.util.Collection;

public class IngredientSearcher extends Searcher<String, Ingredient> {
    public IngredientSearcher(final Collection<? extends Ingredient> ingredients) {
        super(Ingredient::getName, ingredients);
    }
}