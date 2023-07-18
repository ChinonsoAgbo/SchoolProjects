package de.hhn.prog2.lab05.io;

import de.hhn.prog2.lab05.model.Order;
import de.hhn.prog2.lab05.model.Pizza;
import de.hhn.prog2.lab05.model.PizzaSize;
import de.hhn.prog2.lab05.model.PizzaTopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * DataStorage soll bestellungen von ( Klasse Order ) in eine CSV-Datei in txt schreiben
 */
public class DataStorage {
    private static final StorageFormat STORAGE_FORMAT = StorageFormat.TEXT;   // ein und auslesen in Binary format anlegen

    /**
     Liest eine Bestellung aus dem Speicher, abhängig vom Speicherformat, das durch die Konstante STORAGE_FORMAT festgelegt ist.
     @return ein Order-Objekt, das die aus dem Speicher gelesene Bestellung repräsentiert.
     @throws IOException wenn ein Fehler beim Lesen der Bestellung aus dem Speicher auftritt.
     */
    public Order readOrderBySpecifiedFormat() throws IOException {
        return switch (STORAGE_FORMAT) {
            case TEXT -> readOrderCSV();
            case BINARY -> readOrderBin();
            default -> readOrderCSV();
        };
    }

    /**
     * Schreibe order in csv und bin ( binary format )
     * @param order
     * @throws IOException
     */
    public void writeOrderBySpecifiedFormat(Order order) throws IOException {
        switch (STORAGE_FORMAT) {
            case TEXT -> writeOrderCSV(order);
            case BINARY -> writeOrderBin(order);
        }
    }
    /**
     * bestellungen von ( Klasse Order ) in eine CSV-Datei in txt schreiben
     */
    public void writeOrderCSV(Order order)throws IOException {
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter("src/de/hhn/prog2/lab05/io/testout.csv"))) {
            for (Pizza pizza:
                    order.getPizzas()  ) {
                String lineTxt = pizza.toString();
                lineTxt= lineTxt.replace("[", "").replace("]", "");
                outputStream.write(lineTxt);
                outputStream.newLine();

            }
        }
    }

    /**
     * Reads an Order object from a CSV file.
     *
     * @return the Order object read from the CSV file
     * @throws IOException if there is an error reading the file
     */
    public Order readOrderCSV() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/de/hhn/prog2/lab05/io/testout.csv"))) {
            String line = reader.readLine();
            Order order = new Order();
            while (line != null) {
                order.addPizza(outputPizzaStringFormat(line));
                line = reader.readLine();
            }
            return order;
        }
    }

    /**
     * outputStringFormat(String string) takes
     * @param string takes pizza toString and formats it and adds it to pizza konstruktor
     * @return  new pizza objekt
     * @throws IOException
     */
    private Pizza outputPizzaStringFormat(String string)throws IOException{
        try{
            List < PizzaTopping> pizzaToppings = new ArrayList<>(); // Toppping list
                String [] lineArray = string.split(";");
            PizzaSize pizzaSize = PizzaSize.fromString(lineArray[1]);

                if (lineArray.length >= 3){
                    String toppings =  lineArray[2].trim();
                    String[] toppingsLineArray = toppings.split(","); // topping in array spliting
                    for (String stringlist :
                            toppingsLineArray ) {
                        pizzaToppings.add(PizzaTopping.fromString(stringlist.replaceAll("\\s+",""))); // remove spaces
                    }
                }
            return new Pizza(pizzaSize,pizzaToppings); // pizza konstruktor setzen
        } catch (IllegalArgumentException e) {
            throw new IOException(e);
            }
        }
    /**
     * writeOrderBin schreibt Order object in binary in Bin datei
     * @param order
     * @throws IOException
     */
    public void writeOrderBin(Order order) throws IOException {
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src/de/hhn/prog2/lab05/io/bestellung.bin"))){
            for (Pizza pizza :
                    order.getPizzas()) {
                dataOutputStream.writeInt(pizza.getPrice()); // price in binary int einschreiben
                dataOutputStream.writeChars(pizza.toString().replace("[", "").replace("]", ""));
                // pizza objekt in string umschreiben und  entferne "["
                dataOutputStream.writeChars(":"); // füge ":" und notiere das als ende
            }
        }
    }
        /**
         * reads Order from a binary file
         * @return order
         * @throws IOException
         */

    public Order readOrderBin() throws IOException {
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/de/hhn/prog2/lab05/io/bestellung.bin"))){
            Order order = new Order();
            while (true) {
                try {
                    int pizzaPrice = dataInputStream.readInt();
                    boolean endOfPizzaLine = false;
                    String string = "";
                    while (!endOfPizzaLine) {
                        char charLine = dataInputStream.readChar(); // read char bzw txt
                        if (charLine == ':') {
                            endOfPizzaLine = true; // End reading  char "txt"
                             order.addPizza(outputPizzaStringFormat(string));
                        } else {
                            string += charLine;
                        }
                    }
                } catch (EOFException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }
                return order;
        }
    }


}