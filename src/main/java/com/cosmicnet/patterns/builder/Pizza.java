package com.cosmicnet.patterns.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;
    public Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
    abstract static class Builder<T extends Builder<T>>  {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addToppings(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            //toppings.add(Topping.HAM);
            return self();
        }
        protected abstract T self();
        abstract Pizza build();
    }
    @Override
    public String toString() {
        StringBuilder toppingsString = new StringBuilder();
        for (Topping topping : toppings) {
            toppingsString.append(" "+topping);
        }
        return toppingsString.toString();
    }



}
