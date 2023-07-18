package javaSemester_Projects.lab03;

import java.util.ArrayList;

public class Person {
    private String preName, lastName;
    private int age;

    /**
     * @hobbySammlung speichert die sammlung von der Enum eines Objekt.
     */
    private ArrayList<Enum> hobbySammlung = new ArrayList<>(); //


    public Person(String preName, String lastName, int age, Hobby h ) throws IllegalAccessException {
/**
 * Logische Schlüssen für alle ungültige Angaben.
 * falls alle eingaben gültig sind werden die abgespeichert zur der jeweilige Objekt gespeichert
 */
        if(preName == null || preName.trim().isEmpty()){
            throw new IllegalAccessException("ZEILE LEER ");

        } else if (lastName == null || lastName.trim().isEmpty()){
            throw new IllegalAccessException("ZEILE LEER ");

        }else if (age < 0 || h == null){
            throw new IllegalAccessException("ZEILE LEER ");


        }else {
            this.preName = preName;
            this.lastName = lastName;
            this.age = age;
            hobbySammlung.add(h);
        }
    }
    /**
     *
     * @param hobby ruft eine fehler meldung auf, falls eine Person mehr als 5 Hobbies hat, anders falls wird es hinzugefügt
     * @throws NoFreeTimeException
     */
    public void addHobby(Hobby hobby ) throws NoFreeTimeException {
        if( hobbySammlung.size() >= 5) {
            throw new NoFreeTimeException("Hobby großer als 5 ");
        }else{

            hobbySammlung.add(hobby);

        }
    }



    public String getPreName() {
        return preName;
    }

    /**
     *
     *
     *  Set methoden werden genau wie in der Konstruktor abgearbeitet
     * @throws IllegalAccessException
     */

    public void setPreName(String preName) throws IllegalAccessException {

        if( preName == null && preName.isEmpty()){
            throw new IllegalAccessException(" Eingabe ungültig ");
        } else{
            this.preName = preName;
        }

    }

    public String getLastName() {
        return lastName;

    }

    public void setLastName(String lastName) throws IllegalAccessException {

        if(lastName == null && lastName.isEmpty()){

                throw new IllegalAccessException(" Eingabe ungültig ");
            } else {
            this.lastName = lastName;

        }
    }

    public int getAge() {
        return age;

    }

    public void setAge(int age) throws IllegalAccessException {

        if( age < 0){
            throw new IllegalAccessException("Alter ungültig");
        }else {

            this.age = age;
        }
    }




}
