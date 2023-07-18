package de.hhn.prog2.lab05.model;

import java.util.List;

/**

 Diese Klasse repräsentiert eine Pizza, die aus einer Größe, einer Liste von Belägen und einem Preis besteht.
 */
public class Pizza {

    private int price; // Preis der Pizza
    private PizzaSize size; // Größe der Pizza
    private List<PizzaTopping> pizzaToppings; // Liste der Beläge der Pizza

    /**

     Konstruktor für die Pizza-Klasse, der eine Größe und eine Liste von Belägen erhält.
     Der Preis wird basierend auf der ausgewählten Größe und den gewählten Belägen berechnet.
     @param size Die Größe der Pizza
     @param pizzaToppings Eine Liste von Belägen, die auf die Pizza gelegt werden sollen
     */
    public Pizza(PizzaSize size, List<PizzaTopping> pizzaToppings) {
        this.price = size.getPrice(); // Setzt den Grundpreis basierend auf der ausgewählten Größe
        this.size = size;
        this.pizzaToppings = pizzaToppings;
        for (PizzaTopping topping : pizzaToppings) {
            price += topping.getPrice(); // Berechnet den Gesamtpreis basierend auf den ausgewählten Belägen
        }
    }
    /**
     Gibt den Preis der Pizza zurück.
     @return Der Preis der Pizza
     */
    public int getPrice() {
        return price;
    }
    /**

     Gibt die Größe der Pizza zurück.
     @return Die Größe der Pizza
     */
    public PizzaSize getSize() {
        return size;
    }
    /**

     Gibt eine String-Repräsentation der Pizza zurück.
     @return Eine String-Repräsentation der Pizza, die Größe, Beläge und Preis enthält
     */
    @Override
    public String toString() {
        return price + ";" + size + ";" + pizzaToppings;
    }
    /**

     Gibt eine Liste der Beläge der Pizza zurück.
     @return Eine Liste der Beläge der Pizza
     */
    public List<PizzaTopping> getToppings() {
        return pizzaToppings;
    }
}