package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Guest {

    private String name;
    private String document;
    private LocalDate birthDate;
    private List<Guest> guests = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void add(Guest guest) {
        guests.add(guest);
    }

    public Guest[] getGuests() {
        return guests.toArray(new Guest[0]);
    }
}
