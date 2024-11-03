package com.spectrasonic.pluginHider;

import lombok.Getter;
import org.bukkit.command.Command;

import java.util.Set;

/**
 * Manages the blocked commands and provides utility methods for command handling.
 */
@Getter
public class CommandManager {
    private final Main plugin;
    private final Set<String> blockedCommands = Set.of(
            "minecraft:plugins",
            "minecraft:pl",
            "plugins",
            "pl",
            "version",
            "minecraft:version",
            "ver",
            "minecraft:ver"
    );

    public CommandManager(Main plugin) {
        this.plugin = plugin;
    }

    /**
     * Checks if a command should be blocked.
     *
     * @param command The command to check
     * @return true if the command should be blocked
     */
    public boolean isBlockedCommand(Command command) {
        return blockedCommands.contains(command.getName().toLowerCase());
    }
}