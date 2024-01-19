package fr.endit.edoraworld.database.dao;

import fr.endit.edoraworld.database.entity.Player;

public class PlayerDao extends BaseDao<Player> {
    @Override
    protected Class<Player> getClassType() {
        return Player.class;
    }
}
