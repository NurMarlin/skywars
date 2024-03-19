package de.marlin.skywars.task;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

@RequiredArgsConstructor
public class WorldLoaderTask implements Runnable {

    /**
     *
     */
    private final String worldName;

    @Override
    public void run() {

        long time = System.currentTimeMillis();

        Bukkit.createWorld(new WorldCreator(this.worldName));
        System.out.println("The world took " + (System.currentTimeMillis() - time) / 1000 + " seconds to load!");
    }

}
