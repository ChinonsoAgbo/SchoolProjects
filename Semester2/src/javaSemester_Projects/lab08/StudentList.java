package javaSemester_Projects.lab08;
import java.util.Iterator;

public class StudentList  {

    private int arraySize;
    private int arrayCapacity;
    private Student[] studentenArray ;

    /**
     * StudentList the class constructor.
     * Initialisiert die studentenArray und mit der entsprechende arraysize
     * @param arraySize
     */
    public StudentList(int arraySize){
        studentenArray = new Student[arraySize];
        arrayCapacity = arraySize;
    }

    /**
     *
     * @param student fügt neue student solange, die capacity noch zulässt andersfall wird
     *
     */
    public void addStudent(Student student) {
        if (arraySize < arrayCapacity){
            studentenArray[arraySize++]= student;  // add new student object and increment the arraysize
        }
        else{
            System.out.println("StudentList is already full. Cannot add more students.");

        }

    }

    /**
     *
     * @return the student Iterator object.
     */
    public Iterator getIterator() {
        return new StudentIterator();

    }

    /**
     * Implementing the Iterator for the student.
     *
     */
    private class StudentIterator implements Iterator<Student>{
        private int currentIndex;  // currentIndex

        public StudentIterator(){ // iterator constructor
            this.currentIndex = 0;
        }

        /**
         * prüft ob in der Index in der stelle noch Elemente vorhanden.
         * @return true/false
         */
        @Override
        public boolean hasNext() {
            return currentIndex < arraySize;
        }

        /**
         * Zeiget der nächte Element in der Index an
         * @return
         */
        @Override
        public Student next() {
            return studentenArray[currentIndex++];
        }
    }

}
