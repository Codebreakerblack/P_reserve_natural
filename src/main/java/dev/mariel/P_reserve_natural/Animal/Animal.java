package dev.mariel.P_reserve_natural.Animal;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String family;
    private String gender;
    private String countryOrigin;
    private LocalDate entryDate;

    private String picture;

    public Animal() {
    }

    public Animal(Long id, String name, String type, String family, String gender, String countryOrigin,
            LocalDate entryDate, String picture) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.family = family;
        this.gender = gender;
        this.countryOrigin = countryOrigin;
        this.entryDate = entryDate;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
