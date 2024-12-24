package com.spectrasonic.pluginHider;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Main extends JavaPlugin {
    private CommandManager commandManager;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        Main instance = this;
        this.configManager = new ConfigManager(this);
        this.commandManager = new CommandManager(this);
        registerHandlers();
        registerCommands();
        MessageUtils.sendStartupMessage(this);
    }

    @Override
    public void onDisable() {
        MessageUtils.sendShutdownMessage(this);
    }

    private void registerHandlers() {
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);

    }

    public void reload() {
        configManager.reloadConfig();
        commandManager.reloadBlockedCommands();
    }

    public void registerCommands(){
        getCommand("pluginhider").setExecutor(new ReloadCommand(this));
    }
}