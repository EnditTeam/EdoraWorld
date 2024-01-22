package fr.endit.edoraworld;

import com.google.inject.Inject;

import dev.architectury.event.events.common.PlayerEvent;
import fr.endit.edoraworld.database.dao.PlayerDao;
import fr.endit.edoraworld.database.entity.Player;
import fr.endit.edoraworld.enUwUm.Nation;

public class EdoraWorldEventListener {
    PlayerDao playerDao;

    @Inject
    public EdoraWorldEventListener(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public void register() {
        PlayerEvent.PLAYER_JOIN.register(player -> {
            System.out.println("Player " + player.getName().getString() + " joined");

            var edoraPlayer = playerDao.findByUUID(player.getUUID());

            if (edoraPlayer == null) {
                System.out.println("Player " + player.getName().getString() + " new, creating profile...");

                edoraPlayer = new Player(player.getUUID());
                edoraPlayer.setNation(Nation.Kawan);
                playerDao.create(edoraPlayer);
            }
        });
    }
}
