package de.hhn.prog2.lab05.model;

    public enum PizzaSize {
        /**
         * pizza size und price konstanten
         */

        SMALL(Constants.SMALL_PRICE, "Klein"), MEDIUM(Constants.MEDIUM_PRICE, "Mittel"), LARGE(Constants.LARGE_PRICE, "Groß"), EXTRA_LARGE(Constants.EXTRA_LARGE_PRICE, "XL");


        private final int price;
        private final String name;

        PizzaSize(int price, String name) {
            this.price = price;
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name;
        }

        public static PizzaSize fromString(String string) {
            for (PizzaSize pizzaSize : values()) {
                if (pizzaSize.toString().equals(string)) {
                    return pizzaSize;
                }
            }
            throw new IllegalArgumentException("No PizzaSize with name " + string + " found");
        }


        /**
         * Price konstanten
         */

        private static class Constants {
            public static final int SMALL_PRICE = 500;
            public static final int MEDIUM_PRICE = 600;
            public static final int LARGE_PRICE = 800;
            public static final int EXTRA_LARGE_PRICE = 1100;
        }
    }
