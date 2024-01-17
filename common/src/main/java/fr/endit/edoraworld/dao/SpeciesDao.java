package fr.endit.edoraworld.dao;

import fr.endit.edoraworld.model.Species;

public class SpeciesDao extends BaseDao<Species> {

    @Override
    protected Class<Species> getClassType() {
        return Species.class;
    }

}
