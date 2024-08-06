package main.commands.bukkit;

import java.util.logging.Logger;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.MCEventSilencer;

public class PlayerBaseCmd implements IPlayerCmd, CommandExecutor {

  protected MCEventSilencer plugin;
  protected Player player;
  protected String cmdName;
  protected Logger logger;
  protected CommandSender sender;
  protected Command cmd;
  protected String label;
  protected String[] args;

  public PlayerBaseCmd(MCEventSilencer plugin, String cmdName) {
    this.plugin = plugin;
    this.cmdName = cmdName;
    this.logger = Logger.getLogger("MCEventSilencer:" + this.getClass().getSimpleName() + " </>:" + this.cmdName);
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    try {
      if (cmd.getName().equalsIgnoreCase(this.cmdName)) {

        if (!(sender instanceof Player)) {
          sender.sendMessage("This command can only be run by a player instance.");
        } else {
          this.sender = sender;
          this.cmd = cmd;
          this.label = label;
          this.args = args;

          this.player = (Player) sender;
          this.execute();
        }
        return true;
      }
    } catch (Exception e) {
      this.logger.severe(e.getMessage());
    }
    return false;
  }

  @Override
  public void execute() {
    throw new NotImplementedException();
  }

}
