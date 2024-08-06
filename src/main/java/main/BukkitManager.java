package main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;

import main.events.EventManager;

public final class BukkitManager {
    private final static Logger getLogger() {
        return Logger.getLogger("MCEventSilencer:" + BukkitManager.class.getSimpleName() + " </>:");
    }

    public final static Server getServer() {
        return Bukkit.getServer();
    }

    public final static void registerEvents(MCEventSilencer plugin) {
        try {
            // Add you events here..
            new EventManager().register(plugin);
        } catch (Exception e) {
            getLogger().severe(e.getMessage());
        }
    }

    // public final static void registerCommands(MCEventSilencer plugin) {

    // }
}