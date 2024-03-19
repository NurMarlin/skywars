package de.marlin.skywars.state;

public enum GameStateType {

    SETUP("§7[§cSetup§7] ", new SetupState()),
    WAITING("§7[§eWaiting§7] ", new WaitingState()),
    GAME("§7[§6Game§7] ", null),
    RESTART("§7[§cRestart§7] ", null);

    private final String prefix;

    private final GameState gameState;

    GameStateType(String prefix, GameState gameState) {
        this.prefix = prefix;
        this.gameState = gameState;
    }

    public String getPrefix() {
        return prefix;
    }

    public GameState getGameState() {
        return gameState;
    }
}

