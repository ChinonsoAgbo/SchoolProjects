package de.hhn.prog2.lab06.model;

public class Student {
    private String name, preName;
    private int matriculationNumber;

    /**
     * Constructor to assign names and matriculation number
     *
     * @param name
     * @param preName
     * @param matriculationNumber
     * @throws IllegalAccessException wenn name, prename nicht mindesten ein Buchstaben hat wird Illegal.. aufgerufen
     */
    public Student(String name, String preName, int matriculationNumber) throws IllegalAccessException {

        setName(name);
        setPreName(preName);
        setMatriculationNumber(matriculationNumber);
    }

    public String getName() {
        return name;
    }

    /**
     * @param name prüft ob name mindestens einen Buchstaben enthält
     * @throws IllegalAccessException Invalid input exception
     */
    public void setName(String name) throws IllegalAccessException {
        if (!isValidName(name)) {
            throw new IllegalAccessException("Invalid input @ name \n");
        } else {
            this.name = name;
        }
    }

    /**
     * @return the assigned prename
     */
    public String getPreName() {
        return preName;
    }

    /**
     * @param preName prüft ob prename mindestens einen Buchstaben enthält
     * @throws IllegalAccessException Invalid input exception
     */
    public void setPreName(String preName) throws IllegalAccessException {
        if (!isValidName(preName)) {
            throw new IllegalAccessException("Invalid input @ Nachname\n");

        } else {
            this.preName = preName;

        }

    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    /**
     * Sets the matriculation number for a student.
     * The matriculation number must meet the following criteria:
     * - It should not be null.
     * - It should pass the setNamePruefen validation method.
     * - It should have a length of exactly 6 characters after trimming leading and trailing whitespace.
     *
     * @param matriculationNumber The matriculation number to be set.
     * @throws IllegalAccessException If the matriculation number does not meet these
     */
    public void setMatriculationNumber(int matriculationNumber) throws IllegalAccessException {

        if (matriculationNumber < 1_000_000 && matriculationNumber > 99_000){

            this.matriculationNumber =matriculationNumber;
        } else {
            throw new IllegalAccessException("Invalid input @ MatriculationNumber \n");

        }

    }

    /**
     *
     * Checks if the given string is not blank and sets the corresponding boolean value.
     * @param name The string to be checked.
     * @return  boolean based on input values
     */

    private boolean isValidName(String name) {
        if (name != null) {
            return name.matches("(.*[A-z]+)");
        }
        return false;
    }
    @Override
    public String toString() {
        return " Student:   " +
                name +
                ",      " + preName
                + ",     " + matriculationNumber;
    }
}