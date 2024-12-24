package com.spectrasonic.pluginHider;

import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

@RequiredArgsConstructor
public class CommandListener implements Listener {
    private final Main plugin;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().isOp()) {
            return;
        }

        String command = event.getMessage().substring(1).split(" ")[0].toLowerCase();
        if (plugin.getCommandManager().isBlocked(command)) {
            event.setCancelled(true);
            MessageUtils.sendMessage(event.getPlayer(), "&cYou can't use this command.");
        }
    }
}