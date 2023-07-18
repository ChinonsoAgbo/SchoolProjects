package de.hhn.prog2.lab05.view;

import de.hhn.prog2.lab05.model.PizzaSize;
import de.hhn.prog2.lab05.model.PizzaTopping;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
public class PizzaFrame extends JFrame {
    private PizzaConfigPanel pizzaConfigPanel;
    private  PizzaMenuBar pizzaMenuBar;

    public PizzaFrame(){ // Konstruktor
        setTitle("Pizzakonfigurator");  // frame title
       pizzaMenuBar = new PizzaMenuBar(); // Menu Objekt
        setJMenuBar(pizzaMenuBar);// menuebar an der frame überführen

        this.setLayout(new GridBagLayout()); // Frame layout manager

        pizzaConfigPanel =new PizzaConfigPanel(); // pizzaConfiPanel initialzieren und in frame übertragen
        add(pizzaConfigPanel);

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(600, 550);
        setResizable(false);  // verhindern, dass der Frame Grosse unverhindert bleibt
        setLocationRelativeTo(null);  // positioniere den Frame in der MItte
        this.setVisible(true);

    }

    /**
     *
     *   @return die Liste von ( true) selected buttons aus PizzaConfigPanel
     *   wird tatsächlich in Controller bearbeitet
     */
    public List<PizzaTopping> getPizzaToppingsSelected(){
        return pizzaConfigPanel.setMySelectedToppings();
    }

    /**
     *
     * @return selected size
     */
    public PizzaSize getPizzaSizeinFrame(){
        return pizzaConfigPanel.setSizeSeleted();
    }

    /**
     * @param actionListener zur der richtige button objekt einbinden
     */
    public void setExitMenuActionListener(ActionListener actionListener){
        pizzaMenuBar.setExitListener(actionListener);
    }
    public void setSpeichernActionListener(ActionListener actionListener){
        pizzaMenuBar.setSpeichernListener(actionListener);
    }
    public void setLesenActionListener(ActionListener actionListener){
        pizzaMenuBar.setLesenListener(actionListener);
    }
    public void setExitBeendenButtonActionListener (ActionListener actionListener){
        pizzaConfigPanel.setExitBeendenListener(actionListener);
    }
    public void setFeritButtonActionListener(ActionListener actionListener){
        pizzaConfigPanel.setjButtonFertigListener(actionListener);
    }

}
