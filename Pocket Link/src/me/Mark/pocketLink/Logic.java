package me.Mark.pocketLink;

import cn.nukkit.block.Block;
import cn.nukkit.entity.Entity;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;

public class Logic {

 public static void think(String msg) {
	 if (msg != null) {
		 
	if (msg.startsWith("a"))
		PocketLink.broadcast(msg.substring(2));
	else if (msg.startsWith("&e"))
		 PocketLink.broadcast(msg);
	 else if (msg.startsWith("b"))
		 breakBlock(msg);
	 else if (msg.startsWith("c"))
		 placeBlock(msg);
	 else if (msg.startsWith("d"))
		 removeDrop(msg);
	 
	 }
 }
 
		public static void breakBlock(final String msg) {
	    	Thread thread = new Thread(new Runnable() {
	    	     public void run() {
		        		String[] args = msg.split(" ");
		        		System.out.println("Breaking: " + msg);
		        		Level level = PocketLink.inst.getDefaultLevel();
		        		Location loc = new Location(Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), level);
		        		//Block type = level.getBlock(loc);
		        		loc.getLevel().setBlock(loc, Block.get(Block.AIR),true,true);

		        		/*
		        		if (args[5] != "0") {//If blocks are out of sync... don't give extra blocks
		        			Block raw = Block.get(Integer.parseInt(args[5]));
		        		ItemBlock drop = new ItemBlock(raw);
		                drop.setCount(1);
		                drop.setDamage(Integer.parseInt(args[6]));
		               loc.getLevel().dropItem(loc.add(0.5, 0, 0.5), drop);
		        		} else System.out.println("Error... Blocks unsynced");
	    	    	 */
	    	     }
	    	});
	    	thread.start();
 }
		
		public static void placeBlock(String msg) {
	    	Thread thread = new Thread(new Runnable() {
	    	     public void run() {
	    	    	 System.out.println("Placeing: " + msg);
	    	    	 String[] args = msg.split(" ");
	         		System.out.println("Placeing: " + msg);
	         		Level level = PocketLink.inst.getDefaultLevel();
	         		Location loc = new Location(Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), level);
	         		Block block = Block.get(Integer.parseInt(args[5]));
	         		block.setDamage(Integer.parseInt(args[6]));
	         		loc.getLevel().setBlock(loc, block,true,true);
	    	     }
    	});
    	thread.start();
		}
		
		
		public static void removeDrop(String msg) {
			String[] args = msg.split(" ");
			System.out.println("Removeing Drop: " + msg);
			Level w = PocketLink.inst.getDefaultLevel();
			Level level = PocketLink.inst.getDefaultLevel();
			Location drop = new Location(Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), level);
			for(Entity e : w.getEntities()) {
				Location loc = e.getLocation();
				if (Math.abs(drop.getX() - loc.getX()) < 2 && Math.abs(drop.getY() - loc.getY()) < 2 && Math.abs(drop.getZ() - loc.getZ()) < 2) {
					System.out.println("XYZ Match!");
					//Do something else to make sure its the block, rn its not so perfect... and can acutely remove the player, kicking them...
					e.close();
                    System.out.println("Removed Entity!");
                    return;
				}
			}
			
		}
		
		
		
}
