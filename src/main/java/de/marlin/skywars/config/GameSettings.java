package de.marlin.skywars.config;

import de.marlin.skywars.SkyWars;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;

@Getter
public class GameSettings extends GameConfig {

    @Setter
    private boolean setup;

    private int team;
    private int teamMembers;

    public GameSettings() {
        super(SkyWars.SYSTEM_PATH + "configs/","game-settings.yml");
    }

    @Override
    public void initConfig() {

        //check if config is empty
        if (this.configuration.getKeys(false).isEmpty()) {
            this.createDefaultConfig();
            return;
        }

        //set team size to system
        String[] replace = configuration.getString("teams").split("x");
        this.team = Integer.parseInt(replace[0]);
        this.teamMembers = Integer.parseInt(replace[1]);

        //check if setup-mode enabled
        this.setup = configuration.getBoolean("setup-mode");
    }

    @Override
    public void createDefaultConfig() {
        this.configuration.set("teams", "4x1");
        this.configuration.set("setup-mode", true);
        this.team = 4;
        this.teamMembers = 1;
        try {
            this.configuration.save(this.file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
