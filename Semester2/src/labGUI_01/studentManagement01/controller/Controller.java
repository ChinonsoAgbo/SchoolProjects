package labGUI_01.studentManagement01.controller;



import labGUI_01.studentManagement01.model.Student;
import labGUI_01.studentManagement01.model.StudentManagement;
import labGUI_01.studentManagement01.view.ViewFrame;

import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Map;


public class Controller {


    /**
     * listSet needs to be reset and recreated every time the creatStudentAction() or deleteStudent() methods are called,
     */
    private LinkedHashSet<String> listSet;
    private ViewFrame viewFrame;
    private StudentManagement studentManagement;

    public Controller() {
        viewFrame = new ViewFrame();
        studentManagement = new StudentManagement();
        setActionListener();

    }

    /**
     *
     * Sets the action listeners for the buttons in the view frame.
     */
    private void setActionListener() {
        viewFrame.getClickedListenerStudentBtnInFrame(e -> creatStudentAction());
        viewFrame.getClickedDeleteListener(e -> deleteStudent());
    }

    /**
     *Performs the action when the "create student" button is clicked.
     * Add's student when the values are correctly passed.
     * Does not take dublicate matriculation number!
     */
    private void creatStudentAction() {
        try {
            listSet = new LinkedHashSet<>();
            int matricNummer = Integer.parseInt(viewFrame.getmaTricNummer()); // Could throw NumberFormatException.
            String vorname = viewFrame.getVornameFrame();
            String nachname = viewFrame.getNachname();
            studentManagement.matriculate(vorname, nachname, matricNummer);
                //update the label list
            for (Map.Entry<Integer, Student> entry : studentManagement.getHashMap().entrySet()) {
                String value = entry.getValue().toString(); //Get values
                listSet.add(value);
            }
            viewFrame.createListFrame(listSet); // Pass the studentManagement object to the viewFrame
        } catch (IllegalAccessException illeAccExc) {
            JOptionPane.showMessageDialog(viewFrame.getjFrame(),  illeAccExc.getMessage(), "Input Error ", JOptionPane.ERROR_MESSAGE);
    } catch(NumberFormatException eFormat){
        JOptionPane.showMessageDialog(viewFrame.getjFrame(), "Empty Space not allowed  " + eFormat.getMessage(), "Input Error ", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Deletes a student from the student management and updates the label list in the view.
     */

    private void deleteStudent() {
        try {
            int matricNummer = Integer.parseInt(viewFrame.getDeletNummer().trim());

            studentManagement.exmatriculate(matricNummer);
            JOptionPane.showMessageDialog(viewFrame.getjFrame(), matricNummer+" deleted" , "Information ", JOptionPane.INFORMATION_MESSAGE);

           listSet.clear(); // clearing the list and updating it
            for (Map.Entry<Integer, Student> entry : studentManagement.getHashMap().entrySet()) {
                String value = entry.getValue().toString();
                listSet.add(value);
            }
            viewFrame.deleteUpdateList(listSet);

        } catch (NumberFormatException eFormat) {
            JOptionPane.showMessageDialog(viewFrame.getjFrame(), "Input format not allowed " + eFormat.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException nullPointerException) {
            JOptionPane.showMessageDialog(viewFrame.getjFrame(),"Input error: "+ nullPointerException.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        new Controller();
    }
}
