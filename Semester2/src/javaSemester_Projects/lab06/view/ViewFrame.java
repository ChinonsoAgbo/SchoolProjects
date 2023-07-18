package javaSemester_Projects.lab06.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;

/**
 * ViewFrame provides the JFrame to land the GUI
 */
public class ViewFrame {
    private final JpanelConfig jpanelConfig;
    private JFrame jFrame;

    public ViewFrame() {

        jFrame = new JFrame("Student management GUI ");
        jFrame.setLayout(new BorderLayout());
        jpanelConfig = new JpanelConfig();

        jFrame.add(jpanelConfig, BorderLayout.NORTH); // panel und alle eingabe einfügen

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.pack();

    }

    /**
     * get the object of the event listener to be handled
     *
     * @param actionListener btn create student
     */
    public void getClickedListenerStudentBtnInFrame(ActionListener actionListener) {
        jpanelConfig.setCreateStudentListener(actionListener);
    }

    /**
     * get the Object of the event listener to be handled
     */
    public void getClickedDeleteListener(ActionListener actionListener) {
        jpanelConfig.setDeleteStudentButtonListener(actionListener);

    }

    public String getVornameFrame() {
        return jpanelConfig.getNameTextField();
    }

    public String getDeletNummer() {
        return jpanelConfig.getMatricNummerDeleteTextField();
    }

    public String getmaTricNummer() {
        return jpanelConfig.getMatricNummerTextField();
    }

    public String getNachname() {
        return jpanelConfig.getPreNameTextField();
    }

    /**
     *
     * @param string lists of new studets after deleting
     */
    public void createListFrame(LinkedHashSet<String> string) {
        jpanelConfig.createStudentListLabel(string);
        jFrame.pack();
    }

    /**
     *
     * @param string lists of new studets after deleting
     */
    public void deleteUpdateList(LinkedHashSet<String> string) {
        jpanelConfig.deleteUpdateListLabel(string);
        jFrame.pack();
    }

    /**
     *
     *
     * @return this jframe object!
     */
    public JFrame getjFrame() {
        return jFrame;
    }



}
