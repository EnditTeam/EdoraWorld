package fr.endit.edoraworld.database.dao;

import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import com.google.inject.Inject;

import fr.endit.edoraworld.database.SessionFactoryManager;
import fr.endit.edoraworld.database.entity.Player;

public class PlayerDao extends BaseDao<Player> {
    @Inject
    public PlayerDao(SessionFactoryManager manager) {
        super(manager);
    }

    @Override
    protected Class<Player> getClassType() {
        return Player.class;
    }

    @Nullable
    public Player findByUUID(final UUID uuid) {
        var query = this.createNamedQuery("Player.findByUUID");
        query.setParameter("uuid", uuid);
        return query.getSingleResultOrNull();
    }
}
