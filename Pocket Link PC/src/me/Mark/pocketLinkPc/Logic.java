package me.Mark.pocketLinkPc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftItem;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class Logic {

	public static void think(String msg) {
		
		 if (msg.startsWith("a"))
			 Bukkit.broadcastMessage(msg.substring(2));
		 else if (msg.startsWith("&e"))
			 Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',msg));
		 else if (msg.startsWith("b"))
			 breakBlock(msg);
		 else if (msg.startsWith("c"))
			  placeBlock(msg);
		 else if (msg.startsWith("d"))
			  removeDrop(msg);
		
	}
	
	public static void breakBlock(final String msg) {
		BukkitScheduler scheduler = PocketLinkPc.inst.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(PocketLinkPc.inst, new Runnable() {
			@Override
            public void run() {
        		String[] args = msg.split(" ");
        		System.out.println("Breaking: " + msg);
        		Location loc = new Location(Bukkit.getWorld(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        		//Material type = loc.getBlock().getType();
        		loc.getBlock().setType(Material.AIR);
        		/*
        		if (type != Material.AIR) {//If blocks are out of sync... don't give extra blocks
        			Material raw = Material.getMaterial(Integer.parseInt(args[5]));
        		ItemStack drop = new ItemStack(raw);
                drop.setAmount(1);
                drop.setType(raw);
                drop.setDurability(Short.parseShort(args[6]));
                loc.getWorld().dropItem(loc.add(+0.5, +1, +0.5), drop).setVelocity(new Vector(0, 0, 0));
        		} else System.out.println("Error... Blocks unsynced");
        		*/
            }
        }, 0L);
	}
	
	public static void placeBlock(final String msg) {
		BukkitScheduler scheduler = PocketLinkPc.inst.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(PocketLinkPc.inst, new Runnable() {
            @SuppressWarnings("deprecation")
			@Override
            public void run() {
        		String[] args = msg.split(" ");
        		System.out.println("Placeing: " + msg);
        		Location loc = new Location(Bukkit.getWorld(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        		Material mat = Material.getMaterial(Integer.parseInt(args[5]));
        		loc.getBlock().setType(mat);
        		Block block = loc.getBlock();
        		block.setData((byte) Double.parseDouble(args[6]));
        		//int r = Integer.parseInt(args[7]);
        		//block.setData((byte)(block.getData() & r));
            }
        }, 0L);
	}
	
	//TODO
	//When block is dropped, drop it exactly where it was broken, instead of letting it fling anywhere.
	//FOR PC AND MOBINE
	//check id on mobile
	//Check if entity is Dropped_item on mobile
	//TODO
	
	
	@SuppressWarnings("deprecation")
	public static void removeDrop(String msg) {
		String[] args = msg.split(" ");
		System.out.println("Removeing Drop: " + msg);
		World level = Bukkit.getWorld(args[1]);
		Location drop = new Location(level, Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		for(Entity e : level.getEntities()) {
			Location loc = e.getLocation();
			if (Math.abs(drop.getX() - loc.getX()) < 2 && Math.abs(drop.getY() - loc.getY()) < 2 && Math.abs(drop.getZ() - loc.getZ()) < 2) {
				System.out.println("XYZ Match! " + e.getType());
				if (e.getType() == EntityType.DROPPED_ITEM) {
					   CraftItem c = (CraftItem)e;
				       ItemStack item = c.getItemStack();
				int id = item.getType().getId();
				System.out.println("id: " + id + "arg: " + args[4]);
				if (id == Integer.parseInt(args[4])) {
					System.out.println("Id Match!");
				e.remove();
                System.out.println("Removed Entity!");
                return;
				}
			}
			}
		}
		
	}
	
}
