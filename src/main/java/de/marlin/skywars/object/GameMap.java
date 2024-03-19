package de.marlin.skywars.object;

import de.marlin.skywars.SkyWars;
import de.marlin.skywars.config.GameConfig;
import de.marlin.skywars.util.TeamColor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class GameMap extends GameConfig {

    /**
     * Save-Config
     * <p>
     * Team-Size: 8x1
     * Builder-Name: Marlin
     * Round-Time: 8min
     * Border-Size: 100
     * Locations...
     */

    /**
     *
     */
    public static final Map<String, GameMap> GAME_MAP_MAP = new HashMap<>();

    /**
     *
     */
    private String builder;

    /**
     *
     */
    private int roundTime;

    /**
     *
     */
    private int boarderSize;

    /**
     *
     */
    private Map<TeamColor, Location> spawns;

    public GameMap(String name) {
        super(SkyWars.SYSTEM_PATH + "maps/", name + ".yml");

        this.builder = "Marlin";
        this.roundTime = 15;
        this.boarderSize = 100;
        this.spawns = new HashMap<>();
    }

    @Override
    public void initConfig() {

        if (this.configuration.getKeys(false).isEmpty()) {
            this.createDefaultConfig();
            return;
        }

        this.builder = this.configuration.getString("builder");
        this.roundTime = this.configuration.getInt("round-time");
        this.boarderSize = this.configuration.getInt("boarder-size");



    }

    @Override
    public void createDefaultConfig() {
        this.configuration.set("builder", "Marlin");
        this.configuration.set("round-time", 15);
        this.configuration.set("boarder-size", 100);
        try {
            this.configuration.save(this.file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param name
     * @return
     */
    public static GameMap getGameMap(String name) {
        return GAME_MAP_MAP.get(name);
    }
}
