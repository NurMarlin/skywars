package de.marlin.skywars.object;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GamePlayer {

    public static final Map<UUID, GamePlayer> GAME_PLAYER_MAP = new HashMap<>();

    private GameTeam team;

    private int kills;

    public static GamePlayer getGamePlayer(UUID uuid) {
        return GAME_PLAYER_MAP.get(uuid);
    }
    public static GamePlayer getGamePlayer(Player player) {
        return GAME_PLAYER_MAP.get(player.getUniqueId());
    }

}
