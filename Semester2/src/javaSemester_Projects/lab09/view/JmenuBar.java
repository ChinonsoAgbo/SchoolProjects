package javaSemester_Projects.lab09.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class JmenuBar extends JMenuBar {
private ResourceBundle resourceBundle;

private JMenu menu ;
private JMenuItem exit;
    /**
     * JmenuBar Constructor and sets the default language
     */
    JmenuBar (){
       Locale.setDefault(Locale.getDefault());
        resourceBundle= ResourceBundle.getBundle("MessageBundle");

        menu = new JMenu(resourceBundle.getString("file"));
        exit = new JMenuItem(resourceBundle.getString("quit"));
        menu.add(exit);
        add(menu);

    }

    /**
     * Changes the language based on the user specific.
     * @param locale
     */
    public void changeLocaleMenu(Locale locale){
        Locale.setDefault(locale);
        resourceBundle = ResourceBundle.getBundle("MessageBundle");
        menu.setText(resourceBundle.getString("file"));
        exit.setText(resourceBundle.getString("quit"));
    }

    public void addActionListenerMenu(ActionListener actionListener){
        exit.addActionListener(actionListener);
    }
}
