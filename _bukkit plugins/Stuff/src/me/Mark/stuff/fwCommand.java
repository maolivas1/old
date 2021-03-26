package me.Mark.stuff;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class fwCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length > 2)
			if (isInt(args[0]) && isInt(args[1]) && isInt(args[2])) {
				double x = Double.parseDouble(args[0]);
				double y = Double.parseDouble(args[1]);
				double z = Double.parseDouble(args[2]);
				
				Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
				
				spawnFirework(loc);
			}
		
		return true;
	}
	
	public static void spawnFirework(Location location) {
			Location loc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
			
	         //Spawn the Firework, get the FireworkMeta.
            Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
            FireworkMeta fwm = fw.getFireworkMeta();
           
            //Our random generator
            Random r = new Random();
 
            //Get the type
            int rt = r.nextInt(4) + 1;
            Type type = Type.BALL;      
            if (rt == 1) type = Type.BALL;
            if (rt == 2) type = Type.BALL_LARGE;
            if (rt == 3) type = Type.BURST;
            if (rt == 4) type = Type.CREEPER;
            if (rt == 5) type = Type.STAR;
           
            //Get our random colours  
            int r1i = r.nextInt(17) + 1;
            int r2i = r.nextInt(17) + 1;
            Color c1 = getColor(r1i);
            Color c2 = getColor(r2i);
           
            //Create our effect with this
            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
           
            //Then apply the effect to the meta
            fwm.addEffect(effect);
           
            //Generate some random power and set it
            //int rp = r.nextInt(2) + 1;
            fwm.setPower(1);
           
            //Then apply this to our rocket
            fw.setFireworkMeta(fwm);          
	}
	
	
 static boolean isInt(String num){
     try{
        Integer.parseInt(num);
        return true;
     }
     catch(NumberFormatException e){
        return false;
     }
  }
	
	private static Color getColor(int i) {
		Color c = null;
		if(i==1) c=Color.AQUA;
		else if(i==2) c=Color.BLACK;
		else if(i==3) c=Color.BLUE;
		else if(i==4) c=Color.FUCHSIA;
		else if(i==5) c=Color.GRAY;
		else if(i==6) c=Color.GREEN;
		else if(i==7) c=Color.LIME;
		else if(i==8) c=Color.MAROON;
		else if(i==9) c=Color.NAVY;
		else if(i==10) c=Color.OLIVE;
		else if(i==11) c=Color.ORANGE;
		else if(i==12) c=Color.PURPLE;
		else if(i==13) c=Color.RED;
		else if(i==14) c=Color.SILVER;
		else if(i==15) c=Color.TEAL;
		else if(i==16) c=Color.WHITE;
		else if(i==17) c=Color.YELLOW;
		return c;
		}
		 

	
	
	
}
