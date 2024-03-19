package de.marlin.skywars.state;

import de.marlin.skywars.SkyWars;
import de.marlin.skywars.command.StartCommand;
import de.marlin.skywars.object.GameTeam;
import de.marlin.skywars.util.TeamColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WaitingState implements GameState, Listener {

    @Override
    public void onEnable() {

        //create teams with color
        List<TeamColor> teamColors = new ArrayList<>(Arrays.stream(TeamColor.values()).toList());
        for (int i = 0; i < SkyWars.getInstance().getGameSettings().getTeam(); i++) {
            TeamColor randomColor = teamColors.get(new Random().nextInt(teamColors.size()));
            GameTeam.TEAM_MAP.put(randomColor, new GameTeam());

            teamColors.remove(randomColor);
        }

        //debug
        for (TeamColor color : GameTeam.TEAM_MAP.keySet()) {
            System.out.println(color.germanName);
        }
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onRegisterCommands() {
        SkyWars.getInstance().getCommand("start").setExecutor(new StartCommand());
    }

    @EventHandler
    public void onJoinWaiting(PlayerJoinEvent event) {
        event.setJoinMessage("");
    }

    @EventHandler
    public void onQuitWaiting(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

    @EventHandler
    public void onEntityDamageWaiting(EntityDamageEvent event) {
        event.setCancelled(true);
    }

}
