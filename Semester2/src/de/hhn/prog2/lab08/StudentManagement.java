package de.hhn.prog2.lab08;

import java.util.Iterator;

/**
 * Hier werden den code von der StudentList und Student funktionen überprüft
 */
public class StudentManagement {
    public static void main(String[] args) {


        Student student1 = new Student("mike", "james", 123);
        Student student2 = new Student("mike1", "james", 123);
        Student student3 = new Student("mike3", "james", 123);
        Student student4 = new Student("mike4", "james", 123);
        Student student5 = new Student("mike5", "james", 123);


        StudentList studentList = new StudentList(5);
        studentList.addStudent(student1);
        studentList.addStudent(student2);
        studentList.addStudent(student3);
        studentList.addStudent(student4);
        studentList.addStudent(student5);

        Iterator<Student> iterator = studentList.getIterator();

        while (iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student);
        }


        //Legacystudentlist

        System.out.println("Legacystudenten \n");

        LegacyStudentList LegacystudentList = new LegacyStudentList();
        LegacystudentList.addStudent(student1);
        LegacystudentList.addStudent(student2);
        LegacystudentList.addStudent(student3);
        LegacystudentList.addStudent(student4);
        LegacystudentList.addStudent(student5);

        Iterator<Student> iterator2 = LegacystudentList.getIterator(); // gives iterator2 the objekt of the main Iterator to acces the methodes

        while (iterator2.hasNext()){
            Student student = iterator2.next();
            System.out.println(student);
        }
    }
}
