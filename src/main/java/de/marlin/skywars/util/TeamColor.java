package de.marlin.skywars.util;

import lombok.Getter;
import org.bukkit.Material;

@Getter
public enum TeamColor {

    RED("Rot", "§c", Material.RED_WOOL),
    GOLD("Gold", "§6", Material.ORANGE_WOOL),
    YELLOW("Gelb", "§e", Material.YELLOW_WOOL),
    DARK_GREEN("Dunkel-Grün", "§2", Material.GREEN_WOOL),
    GREEN("Grün", "§a", Material.LIME_WOOL),
    AQUA("Aqua", "§b", Material.CYAN_WOOL),
    DARK_BLUE("Dunkel-Blau", "§1", Material.BLUE_WOOL),
    BLUE("Blau", "§9", Material.BLUE_WOOL),
    LIGHT_PURPLE("Lila", "§d", Material.MAGENTA_WOOL),
    DARK_PURPLE("Dunkel-Lila", "§5", Material.PURPLE_WOOL),
    WHITE("Weiß", "§f", Material.WHITE_WOOL),
    GRAY("Grau", "§7", Material.LIGHT_GRAY_WOOL),
    DARK_GRAY("Dunkel-Grau", "§8", Material.GRAY_WOOL),
    BLACK("Schwarz", "§0", Material.BLACK_WOOL);

    public final String germanName;
    public final String color;
    public final Material material;

    TeamColor(String germanName, String color, Material material) {
        this.germanName = germanName;
        this.color = color;
        this.material = material;
    }
}
