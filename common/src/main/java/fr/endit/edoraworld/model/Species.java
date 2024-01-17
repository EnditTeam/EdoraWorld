package fr.endit.edoraworld.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Species {
    public Species(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    Long id;

    String name;

    @OneToMany(mappedBy = "species")
    Set<Animal> animals;
}
