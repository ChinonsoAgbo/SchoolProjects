package javaSemester_Projects.lab09.controller;

import de.hhn.prog2.lab09.modal.Customer;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataManager {
    /**
     * Speichert die Texteingabe in ein csv. Datei
     * @param customer
     * @throws IOException
     */
    public void saveCustomer(Customer customer) throws IOException{

        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ISO_DATE;  //
        String dateFormat = dateTimeFormatter.format(customer.getDateOfBirth());  // format date based on user input date specifically

        try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter("src/de/hhn/prog2/lab09/controller/ioFIleManager.csv"))){
            bufferedWriter.write(customer.getPrename()+","+customer.getLastname()+","+ dateFormat);

        }


    }

    /**
     *Liest text aus csv datei
     * @return customer obj
     * @throws IOException if file cannot be found
     */
    public Customer loadCustomer() throws IOException{

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/de/hhn/prog2/lab09/controller/ioFIleManager.csv"))){
            String[] formInformation = bufferedReader.readLine().split(",");
            LocalDate localDate = LocalDate.parse(formInformation[2]) ; // Uptains date in form of "2007-12-03"
            return new Customer(formInformation[0], formInformation[1],localDate);

    }}

}
