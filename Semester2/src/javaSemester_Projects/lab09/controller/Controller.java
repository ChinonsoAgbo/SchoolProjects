package javaSemester_Projects.lab09.controller;


import de.hhn.prog2.lab09.modal.Customer;
import de.hhn.prog2.lab09.view.Frame;

import javax.swing.*;
import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {


    private Locale locale;
    private DataManager dataManager;
    private Frame frame;
    private ResourceBundle resourceBundle;
    private DateTimeFormatter dateTimeFormatter;

    /**
     * Controller constructor
     */
    Controller() {
        locale = Locale.getDefault();  // get user default local

        frame = new Frame();
        dataManager = new DataManager();
        steuer();
    }


    /**
     * Hat die Aufgabe die Richtige Listener aufzurufen
     */
    public void steuer() {
        frame.setActionlistenerSPeichern(e -> speichern());
        frame.setActionlistenerLaden(e -> laden());
        frame.setActionlistenerJCombo(e -> changeViewLanguage());
        frame.setActionListenerMenu(e -> System.exit(0));
    }


    /**
     * Setze die Eingabe aus der Datei über die Klasse ( DataManager in der Textfield wieder zurück )
     */
    public void laden() {
        resourceBundle = ResourceBundle.getBundle("MessageBundle");
        try {
            String vorname = dataManager.loadCustomer().getPrename();
            String nachname = dataManager.loadCustomer().getLastname();
            LocalDate localDate = dataManager.loadCustomer().getDateOfBirth();
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(locale);

            String formatGeb = localDate.format(dateTimeFormatter1);

            frame.setjTextFieldvorname(vorname);
            frame.setjTextFieldnachname(nachname);
            frame.setjTextFieldgeburtsdatum(formatGeb);

            JOptionPane.showMessageDialog(frame.getjFrame(), resourceBundle.getString("loadSuccess"));
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(frame.getjFrame(), resourceBundle.getString("error"));
        }
    }

    /**
     * speichert user Eingabe gültig in der Customer Constructor.
     * Es wird zuerst die Locale Sprache überprüft und setze die Zahl format ein, wenn richtig eingegeben werden die Daten
     * in Customer Constructor übertragen andersfall wird DateTimeException oder IO Exception geworfen
     */
    public void speichern() {

        try {
            resourceBundle = ResourceBundle.getBundle("MessageBundle");
            String vorname = frame.getVorname();
            String nachName = frame.getNachname();
            String geb = frame.getGeburts();
            LocalDate localDate = null;

            if(einGabePruefen(vorname) || einGabePruefen(nachName)||einGabePruefen(geb)){
                JOptionPane.showMessageDialog(frame.getjFrame(), resourceBundle.getString("inputError"), resourceBundle.getString("errorTitle"), JOptionPane.ERROR_MESSAGE);

            }else {
                if (locale.equals(Locale.ENGLISH)) {
                    localDate = LocalDate.parse(geb, DateTimeFormatter.ofPattern("MMMM d, yyyy"));
                } else {
                    localDate = LocalDate.parse(geb, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                }
            }

            Customer customer = new Customer(vorname, nachName, localDate); // Load input to class instance
            dataManager.saveCustomer(customer);             // Load input to file

            JOptionPane.showMessageDialog(frame.getjFrame(), resourceBundle.getString("saveSuccess")); // display success message
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(frame.getjFrame(), resourceBundle.getString("loadError"), resourceBundle.getString("error"), JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeException dateTimeException) {

            JOptionPane.showMessageDialog(frame.getjFrame(), dateTimeException.getMessage() + " " + resourceBundle.getString("dateTimeParseError"), "Invalid input ", JOptionPane.ERROR_MESSAGE);
        } catch ( NullPointerException nullPointerException ){
            System.out.println();
        }
    }

    /**
     *
     * @param name name string kann nicht leer sein
     * @return true wenn eingabe nicht leer ist
     */
    private Boolean einGabePruefen (String name){
        return name.trim().isEmpty();
    }

    /**
     * Changes view language based on the user specified language
     * Sets DateTimeFormatter to fit the specified language
     */
    private void changeViewLanguage() {

        String languageType = (String) frame.getjComboBox().getSelectedItem();

        if (languageType != null) {

            if (languageType.equals("en")) {
               locale = Locale.ENGLISH;
                dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                frame.changeLocalePanel(locale);
                frame.changeLocaleMenu(locale);
            } else {
                locale = Locale.GERMANY;
                dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                frame.changeLocalePanel(locale);
                frame.changeLocaleMenu(locale);
            }
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
