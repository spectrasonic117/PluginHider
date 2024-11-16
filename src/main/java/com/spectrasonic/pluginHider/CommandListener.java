package com.spectrasonic.pluginHider;

import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

@RequiredArgsConstructor
public class CommandListener implements Listener {
    private final Main plugin;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().substring(1).split(" ")[0].toLowerCase();

        if (plugin.getCommandManager().getBlockedCommands().contains(command)) {
            if (!event.getPlayer().isOp()) {
                event.setCancelled(true);
                MessageUtils.sendMessage(event.getPlayer(), "&cYou can't use this command.");
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onServerCommand(ServerCommandEvent event) {
        // Allow console to execute all commands
    }
}