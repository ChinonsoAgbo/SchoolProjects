package javaSemester_Projects.lab05.view;
import javax.swing.JMenuBar;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PizzaMenuBar extends JMenuBar {
    /**
     * Die Klasse PizzaMenuBar erzeugt die Oben stehende Menubar in der Frame
     */
    private JMenu datei, bestellung, hilfe; // menu liste
    private JMenuItem exitIcon, lesen, speichern ; // frame beenden

    /**
     Erzeugt eine neue Menüleiste für die Pizza-Anwendung.

     Enthält die Menüs "Datei", "Bestellung" und "Hilfe".

     Das "Datei"-Menü enthält das "Beenden"-Icon.

     Das "Bestellung"-Menü enthält die Optionen "Lesen" und "Speichern".

     Die Menüleiste wird erstellt und initialisiert.
     */
    public PizzaMenuBar (){ // konstruktor

        datei = new JMenu("Datei"); // Datei menu objekt erzeugen
        bestellung = new JMenu("Bestellung");
        hilfe = new JMenu("Hilfe");

        exitIcon = new JMenuItem(new ImageIcon("src/de/hhn/prog2/lab05/view/images/xmark.png"));
        datei.add(exitIcon); // Beenden Icon in der Datei einfügen

        lesen = new JMenuItem("Lesen");
        speichern = new JMenuItem("Speichern");
        bestellung.add(lesen);
        bestellung.add(speichern);

        add(datei); //menuliste in menubar einfügen
        add(bestellung);
        add(hilfe);
    }

    /**
     * für die Exit button
     * @param actionListener
     */
    public void setExitListener(ActionListener actionListener){
        exitIcon.addActionListener(actionListener);
    }

    /**
     * für lesen die konfigurierte pizza
     * @param actionListener
     */
    public void setLesenListener(ActionListener actionListener){
        lesen.addActionListener(actionListener);
    }
    /**
     * für speichern die konfigurierte pizza
     * @param actionListener
     */
    public void setSpeichernListener(ActionListener actionListener){
        speichern.addActionListener(actionListener);
    }
}
