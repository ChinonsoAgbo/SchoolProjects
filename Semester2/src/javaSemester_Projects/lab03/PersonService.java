package javaSemester_Projects.lab03;

public class PersonService {

    /**
     * Klasse PersonService . Diese soll eine Methode createPerson zum Erzeugen einer Person und eine Methode printPerson zur
     * Ausgabe einer Person und deren Attribute auf der Konsole zur Verfügung stellen
     */

   private Person ungueltig, gueltig;


    void createPerson(){
try {
    ungueltig= new Person(" ", "Christ", -1, Hobby.JOGGEN);


} catch (IllegalAccessException e) {

    System.out.println(" Zeile leer oder eingabe ungültig");
}

try {
    gueltig = new Person("Otto", "Christ", 20, Hobby.SCHWIMMEN);

} catch (IllegalAccessException e) {

        System.out.println(" Zeile leer oder eingabe ungültig");
    }



}

    public void printPerson() throws NullPointerException{

        createPerson();// initialisierung der person objekten

try {

    System.out.println(ungueltig.getAge());


    System.out.println(gueltig.getAge());
} catch (NullPointerException e ){
    System.out.println("Person wurde nicht erzeugt \n");
}

        try {


            System.out.println("Name: "+ gueltig.getPreName()+ " " + gueltig.getLastName()+ "Alter "+ gueltig.getAge()+ "\n ");
        } catch (NullPointerException e ){
            System.out.println("Person wurde nicht erzeugt ");
        }
     try{
         gueltig.addHobby(Hobby.SCHWIMMEN);
         gueltig.addHobby(Hobby.JOGGEN);
         gueltig.addHobby(Hobby.SCHWIMMEN);
         gueltig.addHobby(Hobby.JOGGEN);
         gueltig.addHobby(Hobby.JOGGEN); // ab hier muss eine Fehler meldung gemeldet werden

     } catch (NoFreeTimeException e) {
         System.out.println("Mehr als 5 hobby\n "); }
    }
}
