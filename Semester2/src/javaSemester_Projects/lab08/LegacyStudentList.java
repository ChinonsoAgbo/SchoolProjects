package javaSemester_Projects.lab08;

import java.util.ArrayList;
import java.util.Iterator;

public class LegacyStudentList {

        private final ArrayList<Student> studentenArrayList;

    /**
     * LegacyStudentList constructor und initialisierung der studentenlist
     */
    public LegacyStudentList(){
            studentenArrayList = new ArrayList<>();

        }

        /**
         *
         * @param student fügt neue student ein
         *
         */
        public void addStudent(Student student) {
           studentenArrayList.add(student);

        }

        /**
         *
         * @return the student Iterator object.
         */
        public Iterator<Student> getIterator() {
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
                return currentIndex < studentenArrayList.size();
            }

            /**
             * Zeiget der nächte Element in der Index an
             * @return
             */
            @Override
            public Student next() {
                return studentenArrayList.get(currentIndex++);
            }


    }

}
