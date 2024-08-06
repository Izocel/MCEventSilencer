package main;

import java.net.http.WebSocket.Listener;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public final class MCEventSilencer extends JavaPlugin implements Listener {

    private Logger logger;

    public MCEventSilencer() {
        this.logger = Logger.getLogger("MCEventSilencer");
        saveDefaultConfig();
    }

    public final String getPluginInfos(boolean toConsole) {
        final StringBuilder sb = new StringBuilder();
        final String devName = toConsole
                ? "@Izo"
                : "<@272924120142970892>";

        sb.append(String.format(this.getName() + " - v1.1.0\n"));
        sb.append(String.format(devName + "\n"));

        return sb.toString();
    }

    public String getFiglet() {
        return """
                \n===============================================================================================================
                                                                                        - MCEventSilencer - v1.0.0
                                                                                        - Author: @Izocel
                \n===============================================================================================================
                """;
    }

    @Override
    public final void onEnable() {
        try {
            BukkitManager.registerEvents(this);
            // BukkitManager.registerCommands(this);

            logger.info(this.getFiglet());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    public final void onDisable() {
        logger.info("Goodbye world !!!");
    }
}
