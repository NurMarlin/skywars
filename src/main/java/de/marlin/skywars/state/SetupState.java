package de.marlin.skywars.state;

import de.marlin.skywars.SkyWars;
import de.marlin.skywars.command.SetupCommand;
import org.bukkit.event.Listener;

public class SetupState implements GameState, Listener {
    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onRegisterCommands() {
        SkyWars.getInstance().getCommand("setup").setExecutor(new SetupCommand());
    }
}
