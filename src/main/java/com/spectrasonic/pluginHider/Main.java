package com.spectrasonic.pluginHider;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for the PluginHider plugin.
 * Handles initialization and shutdown of the plugin.
 */
@Getter
public final class Main extends JavaPlugin {
    private static Main instance;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;

        // Initialize managers
        this.commandManager = new CommandManager(this);

        // Register event listeners
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);


        MessageUtils.sendStartupMessage(this);
        MessageUtils.mcQueenStartup(this);
    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

}