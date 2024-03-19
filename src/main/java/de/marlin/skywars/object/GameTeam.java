package de.marlin.skywars.object;

import de.marlin.skywars.util.TeamColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameTeam {

    public static final Map<TeamColor, GameTeam> TEAM_MAP = new HashMap<>();

    public final ArrayList<Player> players = new ArrayList<>();
    public int teamKills = 0;

    public static GameTeam getGameTeam(TeamColor color) {
        return TEAM_MAP.get(color);
    }

}
