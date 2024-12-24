package com.spectrasonic.pluginHider;

import lombok.Getter;
import java.util.HashSet;
import java.util.Set;

public class CommandManager {
    private final Main plugin;
    @Getter
    private Set<String> blockedCommands;

    public CommandManager(Main plugin) {
        this.plugin = plugin;
        reloadBlockedCommands();
    }

    public void reloadBlockedCommands() {
        this.blockedCommands = new HashSet<>(plugin.getConfigManager().getBlockedCommands());
    }

    public boolean isBlocked(String command) {
        return blockedCommands.contains(command.toLowerCase());
    }
}