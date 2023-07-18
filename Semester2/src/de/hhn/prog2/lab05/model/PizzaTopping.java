package de.hhn.prog2.lab05.model;

public enum PizzaTopping {
    TOMATO("tomato"), CHEESE("Cheese"), SALAMI("Salami"), HAM("Ham"), ANANAS("Ananas"),VEGETABLES("Vegetables"),
    SEAFOOD("Seafood"), NUTELLA("Nutella"), SOUR_CREAM("SourCream");
    private static final int TOPPING_PRICE = 50;

    private final String name;

    PizzaTopping(String name) {
        this.name = name;
    }

    public int getPrice() {
        return TOPPING_PRICE;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     *
     Gibt den PizzaBelag zurück, der dem übergebenen String entspricht.
     @param string Der String, der den Namen des gesuchten Belags enthält
     @return Der PizzaBelag, der dem übergebenen String entspricht
     @throws IllegalArgumentException Wenn kein PizzaBelag mit dem übergebenen Namen gefunden wird
     */
    public static PizzaTopping fromString(String string) {
        for (PizzaTopping pizzaTopping : values()) {
            if (pizzaTopping.toString().equals(string)) {
                return pizzaTopping;
            }
        }
        throw new IllegalArgumentException("No PizzaTopping with name " + string + " found");
    }
}
