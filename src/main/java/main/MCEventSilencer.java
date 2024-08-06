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

        sb.append(String.format(this.getName() + " - v1.0.0\n"));
        sb.append(String.format(devName + "\n"));

        return sb.toString();
    }

    public final String getFiglet() {
        return """
                \n=======================================================================================================================

                MMMMMMMM               MMMMMMMM        CCCCCCCCCCCCC                        EEEEEEEEEEEEEEEEEEEEEE   SSSSSSSSSSSSSSS
                M:::::::M             M:::::::M     CCC::::::::::::C                        E::::::::::::::::::::E SS:::::::::::::::S
                M::::::::M           M::::::::M   CC:::::::::::::::C                        E::::::::::::::::::::ES:::::SSSSSS::::::S
                M:::::::::M         M:::::::::M  C:::::CCCCCCCC::::C                        EE::::::EEEEEEEEE::::ES:::::S     SSSSSSS
                M::::::::::M       M::::::::::M C:::::C       CCCCCC                          E:::::E       EEEEEES:::::S
                M:::::::::::M     M:::::::::::MC:::::C                                        E:::::E             S:::::S
                M:::::::M::::M   M::::M:::::::MC:::::C                                        E::::::EEEEEEEEEE    S::::SSSS
                M::::::M M::::M M::::M M::::::MC:::::C                                        E:::::::::::::::E     SS::::::SSSSS
                M::::::M  M::::M::::M  M::::::MC:::::C                                        E:::::::::::::::E       SSS::::::::SS
                M::::::M   M:::::::M   M::::::MC:::::C                                        E::::::EEEEEEEEEE          SSSSSS::::S
                M::::::M    M:::::M    M::::::MC:::::C                                        E:::::E                         S:::::S
                M::::::M     MMMMM     M::::::M C:::::C       CCCCCC                          E:::::E       EEEEEE            S:::::S
                M::::::M               M::::::M  C:::::CCCCCCCC::::C                        EE::::::EEEEEEEE:::::ESSSSSSS     S:::::S
                M::::::M               M::::::M   CC:::::::::::::::C                        E::::::::::::::::::::ES::::::SSSSSS:::::S
                M::::::M               M::::::M     CCC::::::::::::C                        E::::::::::::::::::::ES:::::::::::::::SS
                MMMMMMMM               MMMMMMMM        CCCCCCCCCCCCC                        EEEEEEEEEEEEEEEEEEEEEE SSSSSSSSSSSSSSS
                                                                    ________________________
                                                                    _::::::::::::::::::::::_
                                                                    ________________________

                                                                                                            - MC-EventSilencer - v1.0.0
                                                                                                            - Author: @Izocel
                \n=======================================================================================================================
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
