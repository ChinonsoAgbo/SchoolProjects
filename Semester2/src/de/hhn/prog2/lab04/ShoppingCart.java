package de.hhn.prog2.lab04;

import java.util.HashMap;
import java.util.Map;

/**
 * @ShoppingCart ist eine Einkaufswagen mit verschiede funktionaläte
 * jedes Produkt wird in einem Map schittstelle gespeichert mit der entsprechende Produkt als schlüsseln als auch die menge als Werte
 */
public class ShoppingCart {

    private final Map<Product, Integer> cart = new HashMap<>();

    /**
     *addProdukt methode speichert jedes eingefügtes Produkt in der cart list
     * @param product produkt Angabe
     * @param quantity menge werte des Produkt
     *
     */
    public void addProduct(Product product, int quantity) {
        int count = cart.getOrDefault(product, 0);
        cart.put(product, count + quantity);
    }

    /**
     *
     * @param product Default methode zum einfügen eines Produkt ohne produktanzahl
     */
    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    /**
     *
     * removeProduct kann eingefügte Produkten wieder aus der Liste entfernen
     * @param product
     * @param quantity
     */

    public void removeProduct(Product product, int quantity) {
        if(cart.containsKey(product)) {
            int count = cart.get(product);
            if(quantity >= count) {
                cart.remove(product);
            } else {
                cart.put(product, count - quantity);
            }
        } else {
            throw new IllegalStateException("Product not found.");
        }
    }


    public void removeProduct(Product product) {
        removeProduct(product, 1);
    }

    /**
     * Alle produkte aus der Liste leeren
     */
    public void removeAll() {
        cart.clear();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    /**
     *
     * @param product
     * @return gib boolean zurück, falls das entsprechende produkt objekt in der liste vorhanden ist
     */
    public boolean containsProduct(Product product) {
        return cart.containsKey(product);
    }

    /**
     *
     * @return berechet und  gibt die gesammte Kosten alle eingefügte Produkten zurück
     */
    public double totalPrice() {
        double ret = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            ret += product.getPrice();
        }
        return ret;
    }

    public int getQuantity(Product product) {
        return cart.get(product);
    }

    public String toString() {
        return cart.toString();
    }

}
