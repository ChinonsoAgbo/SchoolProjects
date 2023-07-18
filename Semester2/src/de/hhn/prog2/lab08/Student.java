package de.hhn.prog2.lab08;

/**
 * Studenten Klasse
 */
public class Student {
    private String prename, lastname;
    private int studentNumber;

    /**
     * Konstructor
     * @param prename
     * @param lastname
     * @param studentNumber
     */
    public Student(String prename, String lastname, int studentNumber) {
        this.prename = prename;
        this.lastname = lastname;
        this.studentNumber = studentNumber;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "prename='" + prename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
