package main.events;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public final class EventManager implements Listener {
    private Logger logger;

    public EventManager() {
        logger = Logger.getLogger("MCEventSilencer:" + this.getClass().getSimpleName() + " </>:");
    }

    public final void register(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public final void handleJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final boolean hasPlayedBefore = player.hasPlayedBefore();

        String msg = null;
        if (!hasPlayedBefore) {
            msg = String.format("Accueillez %s qui nous rejoint pour la première fois sur MC-Discord Québec",
                    player.getName());
        }

        event.setJoinMessage(msg);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public final void handleQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

}