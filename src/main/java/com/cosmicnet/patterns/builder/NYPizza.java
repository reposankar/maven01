package com.cosmicnet.patterns.builder;

public class NYPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE, JUMBO}
    private final Size size;

    static class Builder extends Pizza.Builder<Builder> {
        private Size size;

        public Builder setSize(Size size) {
            this.size = size;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        Pizza build() {
            return new NYPizza(this);
        }
    }

    NYPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    @Override
    public String toString() {
        StringBuilder toppingsString = new StringBuilder();
        toppingsString.append(super.toString());
        if(size!=null)
            toppingsString.append(" "+size);

        return "NYPizza with "+toppingsString.toString();
    }

    public static void main(String[] args) {
        Pizza nyPizza = new NYPizza.Builder().addToppings(Topping.SAUSAGE).addToppings(Topping.ONION).setSize(Size.MEDIUM).build();
        System.out.println("nyPizza : "+nyPizza);
    }

}


