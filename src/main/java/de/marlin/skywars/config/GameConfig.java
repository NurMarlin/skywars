package de.marlin.skywars.config;

import de.marlin.skywars.SkyWars;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
public abstract class GameConfig {

    public final File file;

    public FileConfiguration configuration;

    public GameConfig(String path, String name) {
        this.file = new File(path, name);

        try {
            this.file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    /**
     *
     */
    public abstract void initConfig();

    /**
     *
     */
    public abstract void createDefaultConfig();


}
