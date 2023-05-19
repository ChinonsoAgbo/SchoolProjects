package labGUI_01.studentManagement01.model;

import java.util.HashMap;

/**
 * In der StudentManagement werden studenten in einer hashmap gespeichert
 */
public class StudentManagement {

    private HashMap<Integer, Student> hashMap;

    private Student student;

    public StudentManagement() {
        hashMap = new HashMap<>();
    }

    /**
     * In der Methode matriculate() soll ein student objekt erzeugt werden und in die Hashmap übernommen werden
     * @param name Vorname
     * @param prename Nachname
     * @param matriculationNumber matric nummer
     * @throws IllegalAccessException Daraus folgt, die MatriculationsNummer nicht schon verhanden ist falls doch soll illegalA geworfen werden
     */
    public void matriculate(String name, String prename, int matriculationNumber) throws IllegalAccessException {

        student = new Student(name, prename, matriculationNumber);

        if (hashMap.containsKey(student.getMatriculationNumber())) {
            throw new IllegalAccessException("Dubplicate Matriculation Number is not allowed.\n" + student.getName() + " Cannot be added again!");
        } else {
            hashMap.put(student.getMatriculationNumber(), student);
        }
    }

    /**
     * @param matriculationNumber if the key exists for a given student, the student will be deleted.
    *if not Exception will be thrown
     */
    public void exmatriculate(int matriculationNumber) {

        if (!hashMap.containsKey(matriculationNumber)) {
            throw new NullPointerException("Student not found with " + matriculationNumber);
        } else {
            hashMap.remove(matriculationNumber);
        }
    }

    /**
     * @returns Added students list.
     */
    public HashMap<Integer, Student> getHashMap() {
        return hashMap;
    }


}
