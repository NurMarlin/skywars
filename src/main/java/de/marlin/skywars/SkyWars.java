package de.marlin.skywars;

import de.marlin.skywars.config.GameSettings;
import de.marlin.skywars.object.GameMap;
import de.marlin.skywars.state.GameStateType;
import de.marlin.skywars.util.GameDirectory;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Arrays;

@Getter
public class SkyWars extends JavaPlugin {

    /**
     *
     */
    public static final String SYSTEM_PATH = "plugins/skywars-directory/";

    /**
     *
     */
    @Getter
    private static SkyWars instance;

    /**
     *
     */
    @Getter
    private static GameStateType gameStateType;

    /**
     *
     */
    @Getter
    private GameSettings gameSettings;

    @Override
    public void onLoad() {

        //set instance
        instance = this;

        //create default directories
        Arrays.stream(GameDirectory.values()).forEach(gameDirectory -> {
            if (gameDirectory.getFile().mkdirs()) {
                System.out.println("Directory was successfully created!");
            }
        });
    }

    @Override
    public void onEnable() {

        //load game-settings file
        this.gameSettings = new GameSettings();
        this.gameSettings.initConfig();

        //cached all maps
        File directoryFile = GameDirectory.MAP_DIRECTORY.getFile();
        String[] files = directoryFile.list();

        assert files != null;
        Arrays.stream(files).forEach(map -> {
            String name = map.substring(0, map.lastIndexOf("."));
            GameMap.GAME_MAP_MAP.put(name, new GameMap(name));
            System.out.println("Map " + name + " cached!");
        });

        //start first state (waiting or setup)
        gameStateType = this.gameSettings.isSetup() ? GameStateType.SETUP : GameStateType.WAITING;
        gameStateType.getGameState().onRegisterCommands();
        gameStateType.getGameState().onEnable();

        System.out.println("SkyWars launches with State " + gameStateType.name());
    }

    @Override
    public void onDisable() {

        //remove sky-wars instance
        instance = null;

        //kick all player
        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("Server restart"));
    }

}
