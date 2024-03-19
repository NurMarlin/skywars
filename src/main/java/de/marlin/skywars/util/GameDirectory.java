package de.marlin.skywars.util;

import de.marlin.skywars.SkyWars;
import lombok.Getter;

import java.io.File;

@Getter
public enum GameDirectory {

    CONFIG_DIRECTORY(new File(SkyWars.SYSTEM_PATH + "configs/")),

    MAP_DIRECTORY(new File(SkyWars.SYSTEM_PATH + "maps/"));

    private final File file;

    GameDirectory(File file) {
        this.file = file;
    }

}
