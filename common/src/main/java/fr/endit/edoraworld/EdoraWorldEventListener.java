package fr.endit.edoraworld;

import dev.architectury.event.events.common.PlayerEvent;
import fr.endit.edoraworld.database.dao.PlayerDao;
import fr.endit.edoraworld.database.entity.Player;
import net.minecraft.server.level.ServerPlayer;

public class EdoraWorldEventListener {
    public static void register() {
        PlayerEvent.PLAYER_JOIN.register(EdoraWorldEventListener::onPlayerJoin);
    }

    private static void onPlayerJoin(ServerPlayer player) {
        System.out.println("Player " + player.getName().getString() + " joined");

        var playerDao = new PlayerDao();

        var edoraPlayer = playerDao.findByUUID(player.getUUID());

        if (edoraPlayer == null) {
            System.out.println("Player " + player.getName().getString() + " new, creating profile...");
            playerDao.create(new Player(player.getUUID()));
        }
    }
}
