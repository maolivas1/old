package me.Meatie.Project4.Unused;

import me.Meatie.Commands.Buy;
import me.Meatie.Commands.Ci;
import me.Meatie.Commands.Crafting;
import me.Meatie.Commands.Delhome;
import me.Meatie.Commands.Gm;
import me.Meatie.Commands.God;
import me.Meatie.Commands.Hat;
import me.Meatie.Commands.Head;
import me.Meatie.Commands.Heal;
import me.Meatie.Commands.Help;
import me.Meatie.Commands.Hide;
import me.Meatie.Commands.Home;
import me.Meatie.Commands.I;
import me.Meatie.Commands.Invsee;
import me.Meatie.Commands.Jump;
import me.Meatie.Commands.Killall;
import me.Meatie.Commands.List;
import me.Meatie.Commands.Mob;
import me.Meatie.Commands.Money;
import me.Meatie.Commands.More;
import me.Meatie.Commands.Msg;
import me.Meatie.Commands.Nick;
import me.Meatie.Commands.Pay;
import me.Meatie.Commands.Rank;
import me.Meatie.Commands.Repair;
import me.Meatie.Commands.Sell;
import me.Meatie.Commands.Server;
import me.Meatie.Commands.SetWarp;
import me.Meatie.Commands.SetWorth;
import me.Meatie.Commands.Sethome;
import me.Meatie.Commands.Spawn;
import me.Meatie.Commands.Sudo;
import me.Meatie.Commands.Top;
import me.Meatie.Commands.Tp;
import me.Meatie.Commands.Tpa;
import me.Meatie.Commands.Tpaccept;
import me.Meatie.Commands.Tpahere;
import me.Meatie.Commands.Warp;
import me.Meatie.Commands.Worth;
import me.Meatie.Project2.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class GamesCommands implements Listener {
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) return;
		Player player = event.getPlayer();
		String[] args = event.getMessage().substring(1).split(" ");
		String cmd = args[0].toLowerCase();
		
		if (cmd.equals("tp") || cmd.equals("gm") || cmd.equals("gamemode") || cmd.equals("heal") || cmd.equals("i") || cmd.equals("item") || cmd.equals("god")
		 || cmd.equals("sudo") || cmd.equals("more") || cmd.equals("killall") || cmd.equals("setwarp") || cmd.equals("delwarp")
		 || cmd.equals("hide") || cmd.equals("rank")|| cmd.equals("repair") || cmd.equals("fix") || cmd.equals("mob")|| cmd.equals("spawnmob"))
		if (!Commands.allowed(player, cmd.replace("item", "i").replace("gamemode", "gm").replace("fix", "repair").replace("spawnmob", "mob"))) return;
		
    if (cmd.equals("spawn"))
    	Spawn.cmd(player, args, event);
	else if (cmd.equals("tp"))
		Tp.cmd(player, args, event);
	else if (cmd.equals("gm") || cmd.equals("gamemode"))
		Gm.cmd(player, args, event);
	else if (cmd.equals("heal"))
		Heal.cmd(player, args, event);
	else if (cmd.equals("ci") || cmd.equals("clear"))
		Ci.cmd(player, args, event);
	else if (cmd.equals("hat"))
		Hat.cmd(player, args, event);
	else if (cmd.equals("i") || cmd.equals("item"))
		I.cmd(player, args, event);
	else if (cmd.equals("help"))
		Help.cmd(player, args, event);
	else if (cmd.equals("msg") || cmd.equals("tell") || cmd.equals("pm"))
		Msg.cmd(player, args, event);
	else if (cmd.equals("top"))
		Top.cmd(player, args, event);
	else if (cmd.equals("god"))
		God.cmd(player, args, event);
	else if (cmd.equals("sudo"))
		Sudo.cmd(player, args, event);
	else if (cmd.equals("more"))
		More.cmd(player, args, event);
	else if (cmd.equals("repair") || cmd.equals("fix"))
		Repair.cmd(player, args, event);
	else if (cmd.equals("spawnmob") || cmd.equals("mob"))
		Mob.cmd(player, args, event);
	else if (cmd.equals("head"))
		Head.cmd(player, args, event);
	else if (cmd.equals("jump"))
		Jump.cmd(player, args, event);
	else if (cmd.equals("killall"))
		Killall.cmd(player, args, event);
	else if (cmd.equals("invsee"))
		Invsee.cmd(player, args, event);
	else if (cmd.equals("wb") || cmd.equals("crafting") || cmd.equals("workbench") || cmd.equals("craft"))
		Crafting.cmd(player, args, event);
	else if (cmd.equals("setwarp"))
		SetWarp.cmd(player, args, event);
	else if (cmd.equals("warp"))
		Warp.cmd(player, args, event);
	else if (cmd.equals("delwarp"))
		Warp.cmd(player, args, event);
	else if (cmd.equals("sethome"))
		Sethome.cmd(player, args, event);
	else if (cmd.equals("home"))
		Home.cmd(player, args, event);
	else if (cmd.equals("delhome"))
		Delhome.cmd(player, args, event);
	else if (cmd.equals("sell"))
		Sell.cmd(player, args, event);
	else if (cmd.equals("setworth"))
		SetWorth.cmd(player, args, event);
	else if (cmd.equals("money") || cmd.equals("bal") || cmd.equals("ballance"))
		Money.cmd(player, args, event);
	else if (cmd.equals("worth"))
		Worth.cmd(player, args, event);
	else if (cmd.equals("pay"))
		Pay.cmd(player, args, event);
	else if (cmd.equals("buy"))
		Buy.cmd(player, args, event);
	else if (cmd.equals("tpa"))
		Tpa.cmd(player, args, event);
	else if (cmd.equals("tpaccept"))
		Tpaccept.cmd(player, args, event);
	else if (cmd.equals("tpahere"))
		Tpahere.cmd(player, args, event);
	else if (cmd.equals("hide"))
		Hide.cmd(player, args, event);
	else if (cmd.equals("rank"))
		Rank.cmd(player, args, event);
	else if (cmd.equals("list"))
		List.cmd(player, args, event);
	else if (cmd.equals("nick"))
		Nick.cmd(player, args, event);
	else if (cmd.equals("creative") || cmd.equals("survival") || cmd.equals("games") || cmd.equals("meca"))
		Server.cmd(player, args, event);
    /*
     * ban
     * unban
     * 
     * kick
     * 
     * fix /i
     * 
     * 
     * 
     * 
     * 
     */
	}
	
}
