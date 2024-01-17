package fr.endit.edoraworld.dao;

import fr.endit.edoraworld.model.Animal;

public class AnimalDao extends BaseDao<Animal> {

    @Override
    protected Class<Animal> getClassType() {
        return Animal.class;
    }

}
