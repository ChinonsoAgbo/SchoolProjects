package javaSemester_Projects.lab09.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JPanel komponenten und eingaben in unterkommponenten
 */
public class FormPanel extends JPanel {
private  JPanel jPanelLabelLangugage, jPanelForm; // containers
private JLabel jLabelvorname,jLabelnachname,jLabelgeburtsdatum, jLabelkunde;
private  JComboBox<String> jComboBox;
private JTextField jTextFieldvorname, jTextFieldnachname, jTextFieldgeburtsdatum;
private JButton jButtonLaden, jButtonSpeichern;
private ResourceBundle resourceBundle;

    /**
     * formpanel contruktor
     */
   FormPanel(){
       setLayout(new BorderLayout()); // Main Container layout

       Locale.setDefault(Locale.getDefault());
       resourceBundle = ResourceBundle.getBundle("MessageBundle");
       topContent();
       formInhalte();

   }



    /**
     * Sets the Top components and move these to the main frame Jpanel
     */
    private void topContent(){
       jPanelLabelLangugage = new JPanel();
       jPanelLabelLangugage.setLayout(new BorderLayout());

       String[] languageOptions = {"de_DE","en"}; // jcomboBox inhalte
       jComboBox = new JComboBox<>(languageOptions);

       jPanelLabelLangugage.add(jComboBox, BorderLayout.EAST);           // add in container and position

       Dimension labelContSize = new Dimension(300, 50); // Adjust the width and height as needed
       jPanelLabelLangugage.setPreferredSize(labelContSize);

       add(jPanelLabelLangugage,BorderLayout.NORTH); // Position container panel at the top (NORTH)

   }

    /**
     * Sets and initializes the form Label and Text input in the container
     */
   private void formInhalte(){
      jPanelForm = new JPanel();
      jPanelForm.setLayout(new GridLayout(6,2));

       jLabelkunde = new JLabel(resourceBundle.getString("customer"));
       Font font = jLabelkunde.getFont();
       Font boldFont  = new Font(font.getFontName(),Font.BOLD, font.getSize());
       jLabelkunde.setFont(boldFont);

       JPanel emptyPanel = new JPanel(); // empty panel für positioning view

      jLabelvorname = new JLabel(resourceBundle.getString("forename"));
      jTextFieldvorname = new JTextField("Angela");

      jLabelnachname = new JLabel(resourceBundle.getString("surname"));
      jTextFieldnachname = new JTextField("Merkel");

      jLabelgeburtsdatum = new JLabel(resourceBundle.getString("dob"));
      jTextFieldgeburtsdatum = new JTextField("05.07.1958");

      jButtonLaden = new JButton(resourceBundle.getString("load"));
      jButtonSpeichern = new JButton(resourceBundle.getString("save"));


       jPanelForm.add(jLabelkunde);
       jPanelForm.add(emptyPanel);
       jPanelForm.add(jLabelvorname);
       jPanelForm.add(jTextFieldvorname);
       jPanelForm.add(jLabelnachname);
       jPanelForm.add(jTextFieldnachname);
       jPanelForm.add(jLabelgeburtsdatum);
       jPanelForm.add(jTextFieldgeburtsdatum);
       jPanelForm.add(jButtonLaden);
       jPanelForm.add(jButtonSpeichern);

       add(jPanelForm);

   }
    /**
     * Changes longuage optionally.
     * Eg when the user specifies english as language, language will be reset through ResourceBundle.
     *
     */
    public void changeLocalePanel(Locale locale){
        Locale.setDefault(locale);
        resourceBundle = ResourceBundle.getBundle("MessageBundle");

        jLabelkunde.setText(resourceBundle.getString("customer"));
        jLabelvorname.setText(resourceBundle.getString("forename"));
        jLabelnachname.setText(resourceBundle.getString("surname"));
        jLabelgeburtsdatum.setText(resourceBundle.getString("dob"));
        jButtonLaden.setText(resourceBundle.getString("load"));
        jButtonSpeichern.setText(resourceBundle.getString("save"));

    }

    /**
     * Button lisetener für Laden/ Speichern/ JCombo
     * @param actionListener
     */
   public void  actionListnerLaden(ActionListener actionListener ){
       jButtonLaden.addActionListener(actionListener);
   }
    public void  actionListnerSpeichern(ActionListener actionListener ){
        jButtonSpeichern.addActionListener(actionListener);
    }

    public void actionListenerJCombo(ActionListener actionListener){
       jComboBox.addActionListener(actionListener);
    }
    public String getjTextFieldvorname() {
        return jTextFieldvorname.getText();
    }

    public String getjTextFieldnachname() {
        return jTextFieldnachname.getText();
    }

    public String getjTextFieldgeburtsdatum() {
        return jTextFieldgeburtsdatum.getText();
    }

    public void setjTextFieldvorname(String string ) {
        this.jTextFieldvorname.setText(string);
    }

    public void setjTextFieldnachname(String string ) {
        this.jTextFieldnachname.setText(string);
    }

    public void setjTextFieldgeburtsdatum(String string ) {
        this.jTextFieldgeburtsdatum.setText(string);
    }

    /**
     *
     * @return JComboBox so access to the item that is choosen can be granted
     */
    public JComboBox getjComboBox() {
        return jComboBox ;
    }

}
