package com.spectrasonic.pluginHider;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

@RequiredArgsConstructor
public class ReloadCommand implements CommandExecutor {
    private final Main plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("pluginhider.reload")) {
            MessageUtils.sendMessage(sender, "&cDont have permission to use this command");
            return true;
        }

        plugin.reload();
        MessageUtils.sendMessage(sender, "&aConfig reloaded");
        return true;
    }
}