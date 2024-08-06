package main.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class EventManager implements Listener {
    public void register(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void handleJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final boolean hasPlayedBefore = player.hasPlayedBefore();
        String msg = null;

        if (!hasPlayedBefore) {
            msg = String.format("Accueillez %s qui nous rejoint pour la première fois sur MC-Discord Québec", player.getName());
        }
        event.setJoinMessage(msg);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void handleQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

}