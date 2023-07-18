package de.hhn.prog2.lab09.modal;

import java.time.LocalDate;

public class Customer {
    private String prename, lastname;
    private LocalDate dateOfBirth;

    /**
     *
     * @param prename Vorname
     * @param lastname nachname
     * @param dateOfBirth Geb nach ISO_Date standard
     */
    public Customer(String prename, String lastname, LocalDate dateOfBirth) {
        this.prename = prename;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;

        
    }

    public String getPrename() {
        return prename;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
