package de.hhn.prog2.lab06.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;

/**
 * @version - - -
 * JpanelConfig serves as the main Container, it extends JPanel and it has other  sub jpanel containers included in it
 */
public class JpanelConfig extends JPanel {
    private final LinkedHashSet<String> labelsSet; // lsit of student objects
    private JButton createStudentButton, deleteStudentButton;

    private JTextField matricNummerTextField, nameTextField, preNameTextField, matricNummerDeleteTextField;

    private JPanel mainContainerSub, subContainerLeft, subContainerView, subContainerList; // subcontainers

    JpanelConfig() {
        labelsSet = new LinkedHashSet<>();

        setLayout(new GridBagLayout()); // layout for diese panel ( JpanelConfig )

        mainContainerSub = new JPanel();  // main container
        mainContainerSub.setLayout(new GridBagLayout());

        // initialize component containers
        setSubContainerLeft();
        setSubContainerView();
        setSubContainerList();


        // sub container in main container einfügen

        GridBagConstraints gbcMainPage = new GridBagConstraints();
        gbcMainPage.fill = GridBagConstraints.HORIZONTAL;
        gbcMainPage.gridx = 0;
        gbcMainPage.gridy = 0;
        mainContainerSub.add(subContainerLeft, gbcMainPage); // add and position

        gbcMainPage.gridx = 1;
        gbcMainPage.gridy = 0;
        mainContainerSub.add(subContainerView, gbcMainPage); // add and position

        gbcMainPage.gridx = 0;
        gbcMainPage.gridy = 1;
        gbcMainPage.gridwidth = 20;
        gbcMainPage.ipady = 40;
        mainContainerSub.add(subContainerList, gbcMainPage); // add and position

        add(mainContainerSub); //add (move) to all to class container
    }

    /**
     * sets create and  Delete button components
     */
    private void setSubContainerLeft() {
        subContainerLeft = new JPanel();
        subContainerLeft.setBackground(Color.blue);
        subContainerLeft.setLayout(new BoxLayout(subContainerLeft, BoxLayout.Y_AXIS));
        createStudentButton = new JButton(" Create Student ");
        deleteStudentButton = new JButton("Delete student ");
        subContainerLeft.add(createStudentButton);
        subContainerLeft.add(deleteStudentButton);
    }

    /**
     * sets container to hold textfield components
     */
    private void setSubContainerView() {
        subContainerView = new JPanel();
        subContainerView.setBackground(Color.red);
        subContainerView.setLayout(new GridBagLayout());
        matricNummerTextField = new JTextField("123456");
        matricNummerTextField.setPreferredSize(new Dimension(150, 30));
        nameTextField = new JTextField("Chinonso");
        nameTextField.setPreferredSize(new Dimension(150, 30));
        preNameTextField = new JTextField("Joseph");
        preNameTextField.setPreferredSize(new Dimension(150, 30));

        matricNummerDeleteTextField = new JTextField("123456");

        // position components in Gridbaglayout
        GridBagConstraints gbcView = new GridBagConstraints();
        gbcView.fill = GridBagConstraints.HORIZONTAL;
        gbcView.gridx = 0;
        gbcView.gridy = 0;
        subContainerView.add(matricNummerTextField, gbcView);

        gbcView.gridx = 1;
        gbcView.gridy = 0;
        subContainerView.add(nameTextField, gbcView);

        gbcView.gridx = 2;
        gbcView.gridy = 0;
        subContainerView.add(preNameTextField, gbcView);

        gbcView.gridx = 1;
        gbcView.gridy = 1;
        subContainerView.add(matricNummerDeleteTextField, gbcView);

    }

    /**
     * @return String -> getText() values of components
     */
    public String getMatricNummerDeleteTextField() {
        return matricNummerDeleteTextField.getText();
    }

    /**
     * @return String -> getText() values of components
     */
    public String getMatricNummerTextField() {
        return matricNummerTextField.getText();
    }

    /**
     * @return String -> getText() values of components
     */

    public String getNameTextField() {
        return nameTextField.getText();
    }

    /**
     * @return String -> getText() values of components
     */
    public String getPreNameTextField() {
        return preNameTextField.getText();
    }

    /**
     * sets the list Label in container
     */
    private void setSubContainerList() {

        subContainerList = new JPanel();
        subContainerList.setBackground(Color.gray);
        subContainerList.setLayout(new BoxLayout(subContainerList, BoxLayout.Y_AXIS));

    }

    /**
     * Action listener for create button
     *
     * @param actionListener
     */
    public void setCreateStudentListener(ActionListener actionListener) {
        createStudentButton.addActionListener(actionListener);
    }

    /**
     * set's actionlistener for delete button
     *
     * @param actionListener
     */
    public void setDeleteStudentButtonListener(ActionListener actionListener) {
        deleteStudentButton.addActionListener(actionListener);
    }

    /**
     * Printing the list in the UI without duplicate even when the button action is performed

     *
     * @param stringLinkedHashSet takes only the value from the HashMap from the StudentManagement  class
     */
    public void createStudentListLabel(LinkedHashSet<String> stringLinkedHashSet) {

        labelsSet.addAll(stringLinkedHashSet); // add all student list

        subContainerList.removeAll(); // Clear existing labels

        for (String studentString : labelsSet) {
            subContainerList.add(new JLabel(studentString));  //Add lists and label in container
        }
        subContainerList.revalidate(); // Revalidate the component hierarchy
        subContainerList.repaint(); // Repaint the component

    }

    /**
     * Printing the new list label in the UI without duplicate after deleting
     *
     * @param stringSet list of  students
     */
    public void deleteUpdateListLabel(LinkedHashSet<String> stringSet) {
        subContainerList.removeAll(); // Clear existing labels

        for (String studentString : stringSet) {
            subContainerList.add(new JLabel(studentString));
        }
        subContainerList.revalidate(); // Revalidate the component hierarchy
        subContainerList.repaint(); // Repaint the component
    }

}
