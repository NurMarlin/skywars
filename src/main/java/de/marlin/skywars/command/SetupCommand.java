package de.marlin.skywars.command;

import de.marlin.skywars.state.GameStateType;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommand implements CommandExecutor {

    /**
     * createMap <map-name>
     * setLocation <map-name>
     * load <map-name>
     * tp <map-name>
     * active <map-name>
     */

    private final String prefix = GameStateType.SETUP.getPrefix();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        //check if args is empty
        if (strings.length == 0) {
            this.onSendHelpMessage(commandSender);
            return true;
        }

        switch (strings[0]) {
            case "createMap":
                this.onCreateMapCommand(strings, commandSender);
                break;
            case "setLocation":
                this.onSetLocation(strings, commandSender);
                break;
            case "load":
                this.onMapLoad(strings, commandSender);
                break;
            case "tp":
            case "teleport":
                this.onTeleportToMap(strings, commandSender);
                break;
            default:
                this.onSendHelpMessage(commandSender);
        }

        return false;
    }

    private void onCreateMapCommand(String[] strings, CommandSender sender) {

        if (strings.length > 2) {
            this.onSendHelpMessage(sender);
            return;
        }

        String name = strings[1];



        sender.sendMessage(this.prefix + "§aYou have successfully created the map! Now load them up and create the spawns!");
    }

    private void onSetLocation(String[] strings, CommandSender sender) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(this.prefix + "§cYou can only enter this command as a player!");
            return;
        }

        if (strings.length > 2) {
            this.onSendHelpMessage(sender);
            return;
        }


     //   player.sendMessage(this.prefix + "§aYou have successfully added a location to the " + name + " map");
    }

    private void onMapLoad(String[] strings, CommandSender sender) {

        if (strings.length > 2) {
            this.onSendHelpMessage(sender);
            return;
        }

        long time = System.currentTimeMillis();

        String name = strings[1];
        Bukkit.createWorld(new WorldCreator(name));

        sender.sendMessage(this.prefix + "§aThe world has been successfully loaded!");
        sender.sendMessage(this.prefix + "§cIt took " + (System.currentTimeMillis() - time) / 1000 + " seconds!");
    }

    private void onTeleportToMap(String[] strings, CommandSender sender) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(this.prefix + "§cYou can only enter this command as a player!");
            return;
        }

        if (strings.length > 2) {
            this.onSendHelpMessage(player);
            return;
        }

        String name = strings[1];
        World world = Bukkit.getWorld(name);

        if (world == null) {
            player.sendMessage(this.prefix + "§cThis world does not exist or has not been loaded!");
            return;
        }

        player.teleport(world.getSpawnLocation());
        player.setGameMode(GameMode.CREATIVE);

        sender.sendMessage(this.prefix + "§aYou have been successfully teleported!");
    }

    private void onSendHelpMessage(CommandSender sender) {
        sender.sendMessage(this.prefix + "§eSkyWars Setup-Hilfe:");
        sender.sendMessage(this.prefix + " ");
        sender.sendMessage(this.prefix + "§7- §e/setup createMap <map-name>");
        sender.sendMessage(this.prefix + "§7- §e/setup setLocation <map-name>");
        sender.sendMessage(this.prefix + "§7- §e/setup load <map-name>");
        sender.sendMessage(this.prefix + "§7- §e/setup teleport <map-name>");
        sender.sendMessage(this.prefix + " ");
        sender.sendMessage(this.prefix + "§7§m------------------------------------ ");
    }

}
