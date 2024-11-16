package com.spectrasonic.pluginHider;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Main extends JavaPlugin {
    private static Main instance;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        MessageUtils.sendStartupMessage(this);
        instance = this;
        this.commandManager = new CommandManager(this);
        registerManager();
    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

    public void registerManager() {
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);
    }

}