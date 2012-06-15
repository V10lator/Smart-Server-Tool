package com.github.ysl3000;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickManager {

	public static void kick(CommandSender sender, String command,
			String[] args, Command cmd) {

		Player player = (Player) sender;
		if (command.equalsIgnoreCase("kick")) {

			if (args.length == 0) {

				player.sendMessage(SmartServerTool.plugin.getConfig()
						.getString("commands.kick.usage"));
			} else if (args.length == 1) {

				if (args[0].equalsIgnoreCase("-a")) {

					for (Player p : Bukkit.getOnlinePlayers()) {
						if (!p.getName().equalsIgnoreCase(player.getName())) {
							p.kickPlayer(player.getName() + " has kicked you");
						}

					}
				} else {
					Bukkit.getPlayer(args[0]).kickPlayer(
							player.getName() + " has kicked you");
				}

			} else

			if (args.length == 2) {

				if (args[0].equalsIgnoreCase("-a")) {

					for (Player p : Bukkit.getOnlinePlayers()) {

						if (!p.getName().equalsIgnoreCase(player.getName())) {
							p.kickPlayer(args[1]);
						}

					}
				} else {

					Bukkit.getPlayer(args[0]).kickPlayer(args[1]);
					Bukkit.broadcastMessage(args[0] + " is kicked because "+ args[1]);
				}
			}

		}
	}
}
