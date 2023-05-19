package labGUI_01.pizzaKonfiguration.pizzaGUI_01.view;

import labGUI_01.pizzaKonfiguration.pizzaGUI_01.model.PizzaSize;
import labGUI_01.pizzaKonfiguration.pizzaGUI_01.model.PizzaTopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @PizzaConfigPanel dient als der Hauptkontainer für den Frame
 */
public class PizzaConfigPanel extends JPanel {
    // Datenfelder
    private JPanel  jPanelSize, jPanelBeilage, jPanelBild, buttonPanel;
    private  MyJRadioButtons jRadioButtons;
    private JLabel jLabelGrosse;
    private JLabel jLabelBeilage;
    private List<MyJRadioButtons> toppingsList;
    private JPanel toppingPanel;
    private JComboBox jComboBox ;
    private JLabel jLabelImage;
    private JButton jButtonFertig;
    private JButton jButtonBeenden;


    public PizzaConfigPanel(){  // konstruktor
        setLayout(new GridBagLayout()); // Layout manager

        initGrosse(); // pizza size in der konstruktor initialisieren
        initBeiLage(); // beilage in der Konstruktor initialisieren
        initBild(); // init bild
        intiButtons();  // buttons initialisieren

        // unter Container positionisieren
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // große
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(jPanelSize, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL; // beilage
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(jPanelBeilage, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL; // beilage
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(jPanelBild, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL; // beilage
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipady = 20;
        this.add(buttonPanel, gbc);



    }

    /**
     * @initGrosse() unter kontainer für JComboBox und label
     */

    private  void initGrosse(){
        jPanelSize = new JPanel();

        jPanelSize.setLayout(new GridBagLayout()); // unter container layout manager
        jLabelGrosse= new JLabel("Größe");
        jComboBox = new JComboBox<>(PizzaSize.values());

        jPanelSize.add(jLabelGrosse); // komponente in Kontainer übergeben

        GridBagConstraints gbcJPanelSize = new GridBagConstraints(); // positionierung festlegen
        gbcJPanelSize.fill = GridBagConstraints.HORIZONTAL;
        gbcJPanelSize.gridx =1;
        gbcJPanelSize.gridy = 0;
        gbcJPanelSize.ipady = 40;
        jPanelSize.add(jComboBox,gbcJPanelSize);
    }
    /**
     * @initBeilage() unter kontainer für radiobuttons und label
     */

    private void initBeiLage(){
        jPanelBeilage = new JPanel();// unter kontainer für label und Radiobutton

        jPanelBeilage.setLayout(new GridBagLayout()); //
        jLabelBeilage = new JLabel("Beilage");

        toppingsList = new ArrayList<>();
        toppingPanel = new JPanel();  //  unter kontainer für den Kontainer jPanelBeilage
        toppingPanel.setLayout(new BoxLayout(toppingPanel, BoxLayout.PAGE_AXIS));

        // einfügen und positionieren
        GridBagConstraints gbcJPanelBeilage = new GridBagConstraints();
        gbcJPanelBeilage.fill = GridBagConstraints.HORIZONTAL;
        gbcJPanelBeilage.gridx = 0;
        gbcJPanelBeilage.gridy = 0;
        jPanelBeilage.add(jLabelBeilage,gbcJPanelBeilage);        //Beilage label einfügen

        gbcJPanelBeilage.gridx = 1;
        gbcJPanelBeilage.gridy = 1;
        for (PizzaTopping stToppings:
                PizzaTopping.values()) {
            jRadioButtons = new MyJRadioButtons(stToppings);
            toppingsList.add(jRadioButtons);
            toppingPanel.add(jRadioButtons);
        }
        jPanelBeilage.add(toppingPanel,gbcJPanelBeilage); // radioButton einfügen

    }
    /**
     *InitBilder methode zum pizza Bild einfügen einfügen
     */
    private void initBild(){
        // image panel
        jPanelBild  = new JPanel();
        jPanelBild.setLayout(new GridBagLayout());
        jLabelImage = new JLabel();
        // Load the original image
        String imageSource = "Semester2/src/labGUI_01/pizzaKonfiguration/pizzaGUI_01/view/images/HomePizza3.jpeg";
        ImageIcon originalImageIcon = new ImageIcon(imageSource);
        Image originalImage = originalImageIcon.getImage();
        // Reduce the size of the image
        int newWidth = 300; // Specify the desired width
        int newHeight = 200; // Specify the desired height
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the scaled image
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

// Update the jLabelImage with the scaled image
        jLabelImage.setIcon(scaledImageIcon);
        // jLabelImage.setHorizontalTextPosition(2);
        GridBagConstraints gbcImageLabel = new GridBagConstraints();
        gbcImageLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcImageLabel.ipady = 100;
        gbcImageLabel.ipadx = 100;
        jPanelBild.add(jLabelImage,gbcImageLabel);

    }

    /**
     * @initButtons() methode zum einfügen den Buttons und Icons
     */
    private void intiButtons(){
        //Button Jpanel
        buttonPanel = new JPanel();
        setLayout(new GridBagLayout());
        jButtonBeenden = new JButton(new ImageIcon("Semester2/src/labGUI_01/pizzaKonfiguration/pizzaGUI_01/view/images/xmark.png"));
        jButtonBeenden.setPreferredSize(new Dimension(100,50));
        jButtonFertig = new JButton(new ImageIcon("Semester2/src/labGUI_01/pizzaKonfiguration/pizzaGUI_01/view/images/checkmark.png"));
        jButtonFertig.setPreferredSize(new Dimension(100,50));

        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.fill = GridBagConstraints.HORIZONTAL;
        gbcButton.gridx=1;
        gbcButton.gridy =0;
        buttonPanel.add(jButtonFertig,gbcButton);
        gbcButton.gridx=2;
        gbcButton.gridy =0;
        buttonPanel.add(jButtonBeenden,gbcButton);

    }

    /**
     *
     * @param actionListener bindet richtige listener zu den buttons
     */
    public void  setExitBeendenListener (ActionListener actionListener){
        jButtonBeenden.addActionListener(actionListener);
    }
    public void setjButtonFertigListener(ActionListener actionListener){
        jButtonFertig.addActionListener(actionListener);
    }

    /**
     *
     * @return die Liste von ( true) selected buttons
     */
    public List<PizzaTopping> setMySelectedToppings(){
        List<PizzaTopping> mySeletedToppingList = new ArrayList<>();
        for (MyJRadioButtons myJRadioButtons : toppingsList){
            if( myJRadioButtons.isSelected())
                mySeletedToppingList.add(myJRadioButtons.getPizzaTopping());
        }
        return mySeletedToppingList;
    }

    /**
     *
     * @return  Returns the current selected item.
     */
    public PizzaSize setSizeSeleted() {
        return (PizzaSize) jComboBox.getSelectedItem();
    }


    /**
     * MyJRadioButtons extends JRadioButton to set the Radiobutton titel enum list als string
     */
        class MyJRadioButtons extends JRadioButton {


        private final PizzaTopping pizzaTopping; // klasse PizzaTopping

        MyJRadioButtons(PizzaTopping pizzaTopping) {
            super(String.valueOf(pizzaTopping).trim());
            this.pizzaTopping = pizzaTopping;
        }

        public PizzaTopping getPizzaTopping() {
            return pizzaTopping;
        }
    }


}
