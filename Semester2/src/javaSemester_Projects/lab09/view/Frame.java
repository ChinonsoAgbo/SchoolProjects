package javaSemester_Projects.lab09.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Frame {


    private JFrame jFrame;
    private FormPanel formPanel;
    private JmenuBar jmenuBar;

    public Frame() {
        jFrame = new JFrame();

        jmenuBar = new JmenuBar();
        jFrame.setJMenuBar(jmenuBar);

        formPanel = new FormPanel();

        jFrame.add(formPanel);


        jFrame.pack();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        jFrame.setVisible(true);
    }


    public void setActionlistenerLaden(ActionListener actionListener) {
        formPanel.actionListnerLaden(actionListener);
    }

    public void setActionlistenerSPeichern(ActionListener actionListener) {
        formPanel.actionListnerSpeichern(actionListener);
    }

    /**
     * Menu actionListener
     *
     * @param actionListener
     */
    public void setActionListenerMenu(ActionListener actionListener) {
        jmenuBar.addActionListenerMenu(actionListener);
    }

    /**
     * Combo to change language
     *
     * @param actionListener
     */
    public void setActionlistenerJCombo(ActionListener actionListener) {
        formPanel.actionListenerJCombo(actionListener);
    }

    public String getVorname() {
        return formPanel.getjTextFieldvorname();
    }

    public String getNachname() {
        return formPanel.getjTextFieldnachname();
    }

    public String getGeburts() {
        return formPanel.getjTextFieldgeburtsdatum();
    }

    /**
     * @return Jframe Object
     */
    public JFrame getjFrame() {
        return jFrame;
    }

    public JComboBox getjComboBox() {
        return formPanel.getjComboBox();
    }


    public void changeLocalePanel(Locale locale) {
        formPanel.changeLocalePanel(locale);
    }

    public void changeLocaleMenu(Locale locale) {
        jmenuBar.changeLocaleMenu(locale);
    }


    public void setjTextFieldvorname(String string) {
        formPanel.setjTextFieldvorname(string);
    }

    public void setjTextFieldnachname(String string) {
        formPanel.setjTextFieldnachname(string);
    }

    public void setjTextFieldgeburtsdatum(String string) {
        formPanel.setjTextFieldgeburtsdatum(string);
    }
}
