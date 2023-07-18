package de.hhn.prog2.lab05.model;

import java.util.ArrayList;
import java.util.List;

/**

 Order Klasse repräsentiert eine Bestellung von Pizzas mit einer eindeutigen Bestellungs-ID und einer Liste von Pizzas.
 */
public class Order {
    // die Bestellungs-ID wird als statisches Attribut definiert, damit sie für jede Bestellung inkrementiert wird.
    private static long id = 1;
    private long orderId;
    private List<Pizza> pizzas;

    /**

     Konstruktor erstellt eine Bestellung mit einer eindeutigen Bestellungs-ID und einer leeren Liste von Pizzas.
     */
    public Order() {
        this.orderId = id++;
        this.pizzas = new ArrayList<>();
    }
    /**

     Fügt eine Pizza zur Liste der Pizzas in der Bestellung hinzu, falls die übergebene Pizza nicht null ist.
     @param pizza Die Pizza, die der Bestellung hinzugefügt werden soll.
     */
    public void addPizza(Pizza pizza) {
        if (pizza != null) {
            pizzas.add(pizza);
        }
    }
    /**

     Entfernt eine Pizza aus der Liste der Pizzas in der Bestellung, falls die übergebene Pizza nicht null ist.
     @param pizza Die Pizza, die aus der Bestellung entfernt werden soll.
     */
    public void removePizza(Pizza pizza) {
        if (pizza != null) {
            pizzas.remove(pizza);
        }
    }
    /**

     Gibt eine Liste der Pizzas in der Bestellung zurück.
     @return Die Liste der Pizzas in der Bestellung.
     */
    public List<Pizza> getPizzas() {
        return pizzas;
    }
}