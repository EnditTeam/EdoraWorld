package fr.endit.edoraworld.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {
    Animal() {
    }

    Animal(String name, Species species) {
        this.name = name;
        this.species = species;
    }

    @Id
    @GeneratedValue
    Long id;

    String name;

    @ManyToOne
    Species species;
}
