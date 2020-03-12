package com.spacetravel.spacetravel.enity;


import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String name;
    private String sourname;
    private Character sex;
    private String country;
    private String notes;
    private Date birthDate;

    @ManyToMany(mappedBy = "tourist",cascade = CascadeType.PERSIST)
    private List<Flight> flights = new LinkedList<Flight>();

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSourname() {
        return sourname;
    }

    public Character getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public String getNotes() {
        return notes;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSourname(String sourname) {
        this.sourname = sourname;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }



    public Tourist(){

    }
    public Tourist(String name, String sourname, Character sex, String country, String notes, Date birthDate) {
        this.name = name;
        this.sourname = sourname;
        this.sex = sex;
        this.country = country;
        this.notes = notes;
        this.birthDate = birthDate;
    }
    public void addFlight (Flight f){
        flights.add(f);
    }
    public void removeFlight (Flight f){
        flights.remove(f);
    }

}
