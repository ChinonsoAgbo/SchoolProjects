package javaSemester_Projects.lab05.controller;

import de.hhn.prog2.lab05.io.DataStorage;
import de.hhn.prog2.lab05.model.Order;
import de.hhn.prog2.lab05.model.Pizza;
import de.hhn.prog2.lab05.model.PizzaSize;
import de.hhn.prog2.lab05.model.PizzaTopping;
import de.hhn.prog2.lab05.view.PizzaFrame;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * Das vorliegende Code-Beispiel ist eine Java-Klasse mit dem Namen "Controller".
 * Diese Klasse ist Teil eines Programms, das eine Benutzeroberfläche zum Bestellen von Pizzen bereitstellt.
 * Der Controller ist für die Steuerung der Anwendung verantwortlich und stellt eine Verbindung zwischen der Benutzeroberfläche, den Daten und dem Modell her.
 * Die klasse importiert vier Modelle, die für das Programm relevant sind: "Order", "Pizza",
 * "pizzaSize" und "PizzaTopping". zudem werden die klassen "DataStorage" und "PizzaFrame" importiert
 *
 */
public class Controller {

    private Order pizzaOrder;
    private DataStorage dataStorage;
    private PizzaFrame pizzaFrame;
    private Pizza pizzaObjekt ;

    /**
     Konstruktor der Controller-Klasse.
     Erstellt eine neue Instanz des PizzaFrame, Order und DataStorage.
     Ruft die Methode setActionListener auf.
     */
    Controller(){
        pizzaFrame = new PizzaFrame();
        pizzaOrder = new Order();
        dataStorage = new DataStorage();
        setActionerListener();
    }

    /**
     Setzt die ActionListener für die verschiedenen Buttons im PizzaFrame.
     Wenn ein Ereignis ausgelöst wird, wird die entsprechende Methode aufgerufen.
     */
   private void setActionerListener (){
       pizzaFrame.setExitMenuActionListener(e -> exitFrame());
        pizzaFrame.setExitBeendenButtonActionListener(e -> exitFrame());
        pizzaFrame.setFeritButtonActionListener(e -> fertigButton());
       pizzaFrame.setLesenActionListener(e -> readOrder());
        pizzaFrame.setSpeichernActionListener(e -> saveOrder());

    }
    /**
     Beendet das Programm und zeigt eine Bestätigungsdialogbox an.
     */
    private void exitFrame(){
     int n=   JOptionPane.showConfirmDialog(pizzaFrame, "Wollen Sie wirklich das Programm beenden? ",
                "Pizza bestellen", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (n == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Speichert der konfigurierte pizza beim Aufruf in der Pizza klasse konstruktor ( pizzaObjekt)
     * Es soll dabei eine Dialog fernster erscheinen nach dem Klick button (fertig)
     *  Beim Ok wird der pizza  Objekt in Order gespeichert
     *
     */
    private void fertigButton(){
        List<PizzaTopping>  mySeletedToppings = pizzaFrame.getPizzaToppingsSelected(); // speichert alle liste von allen aufgenommenen Toppings
        PizzaSize pizzaSize = pizzaFrame.getPizzaSizeinFrame();  // speichert eingegebene size

       pizzaObjekt = new Pizza(pizzaSize,mySeletedToppings);

        System.out.println("Pizza Size: " + pizzaObjekt.getSize() + "Pizza Price: " + pizzaObjekt.getPrice() +
                "Pizza Toppings: " + pizzaObjekt.getToppings());

        int option= JOptionPane.showConfirmDialog(pizzaFrame, "Pizza kostet " + pizzaObjekt.getPrice() +
                        " Cent. Möchten Sie sie der Bestellung hinzufügen?",
                "Pizza bestellen", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE); // Dialog fernster
        if ( option == JOptionPane.OK_OPTION) {
            pizzaOrder.addPizza(pizzaObjekt);
        }
    }

    /**

     Liest eine Bestellung aus dem Datenspeicher und zeigt eine Zusammenfassung der Bestellung in einem Dialogfeld an.
     Die Methode ruft dazu die Methode readOrder() der Klasse DataStorage auf und holt sich die Bestellung.
     Anschließend werden die Pizzen der Bestellung zu einem String zusammengefügt und in einem Dialogfeld angezeigt.
     Wenn ein Fehler beim Lesen der Bestellung auftritt, wird eine Fehlermeldung in einem separaten Dialogfeld angezeigt.
     */
    private void readOrder(){
        try {
            StringBuilder stringBuilder = new StringBuilder();
            pizzaOrder = dataStorage.readOrderBySpecifiedFormat();
            List<Pizza> pizzaList = pizzaOrder.getPizzas();
            for (Pizza pizza:
                 pizzaList) {
                stringBuilder.append(pizza);
                stringBuilder.append("\n");
            }
            JOptionPane.showMessageDialog(pizzaFrame, "Ihre Bestellung: "+ stringBuilder.toString(),
                  "Bestellung ",  JOptionPane.INFORMATION_MESSAGE);

        }catch (IOException e ){
            JOptionPane.showMessageDialog(pizzaFrame, "Error " + e.getMessage(), "Error title", JOptionPane.ERROR_MESSAGE);

        }
    }
    /**

     Speichert die aktuelle Bestellung in den Datenspeicher, indem die Methode writeOrder() der Klasse DataStorage aufgerufen wird.
     Wenn ein Fehler beim Speichern der Bestellung auftritt, wird eine Fehlermeldung in einem separaten Dialogfeld angezeigt.
     */
    private void saveOrder(){
        try {
            dataStorage.writeOrderBySpecifiedFormat(pizzaOrder);
        }catch (IOException e){
            JOptionPane.showMessageDialog(pizzaFrame, "Information Error beim Speichern der Bestellung: "
                    + e.getMessage(), "Error title", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * steuerung pizza konfiguration;
     * version: 15.05.23
     */
    public static void main(String[] args) {
        new Controller();
    }
}
