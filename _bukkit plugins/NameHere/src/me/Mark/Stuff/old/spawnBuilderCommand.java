package me.Mark.Stuff.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import me.Mark.stuff.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class spawnBuilderCommand implements CommandExecutor {
	
	static ArrayList<NPC> list = new ArrayList<NPC>();
	static HashMap<NPC, Location> loc = new HashMap<NPC, Location>();
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			player.sendMessage(ChatColor.GREEN + "Spawning Builder...");
			
			NPCRegistry registry = CitizensAPI.getNPCRegistry();
			NPC npc = registry.createNPC(EntityType.PLAYER, "MyNPC");
			npc.spawn(player.getLocation());
		    npc.addTrait(CitizensAPI.getTraitFactory().getTrait("builder"));
			
			list.add(npc);
		}
		
		return true;
	}
	/*
	npc.getNavigator().setTarget(entity, true); // aggressively attack an entity
	*/
	public static void walk() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.inst, new Runnable() {
            @Override
            public void run() {
            	for (NPC npc : list) {
            		Location pos = npc.getEntity().getLocation();
            		
            		if (loc.containsKey(npc))
            			
            			if (loc.get(npc).getX() > pos.getX() - 1 && loc.get(npc).getX() < pos.getX() + 1
            				&& loc.get(npc).getZ() > pos.getZ() - 1 && loc.get(npc).getZ() < pos.getZ() + 1) {
            		//if (loc.get(npc).getX() == (int)pos.getX() && loc.get(npc).getZ() == (int)pos.getZ()) {
            			loc.remove(npc);//Start new path
            		}
            			
            		
            		if (!loc.containsKey(npc)) {
                        int x = new Random().nextInt(9) + -5;//-5-5
                        int y = new Random().nextInt(9) + -5;//-5-5
                        int z = new Random().nextInt(9) + -5;//-5-5
            			Location path = new Location(pos.getWorld(), (int)pos.getX() + x, (int)pos.getY() + y, (int)pos.getZ() + z);
            			loc.put(npc, path);
            			System.out.println("Setting Path To: " + path.getX() + " " + path.getZ());
            			npc.getNavigator().setTarget(path);
            		} else {
            		Location path = loc.get(npc);
            		System.out.println("Walking to: " + path.getX() + " " + path.getZ() + " Curently At: " + (int)pos.getX() + " " + (int)pos.getZ());
            		npc.getNavigator().setTarget(loc.get(npc));
            		}
            	}
            }
        }, 0L, 20L);
	}
	
	
	
	
}
