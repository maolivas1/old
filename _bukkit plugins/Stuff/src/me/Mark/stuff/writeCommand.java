package me.Mark.stuff;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class writeCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
  			 if (!sender.isOp()) return true;
  			 //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill 119 140 580 159 145 580 air");
  			 
  			 Material block = Material.WOOL;
  			 
  			if(sender instanceof Player) {
		        Player player = (Player) sender;
			double id = player.getItemInHand().getTypeId();
			if ((id <= 208 && id != 0) || id == 326 || id == 327 || id == 354 || id == 331)
		       block = player.getItemInHand().getType();
  			 
  			StringBuilder builder = new StringBuilder();
  			for(String s : args)
  			builder.append(s);
  			String msg = builder.toString();
			 
  			 //Location loc = new Location(Bukkit.getWorld("world"), 119, 140, 580);
  			 Location loc = player.getLocation();
  			
  			 int count = 0;
  			 
  			for (int i = 0; i < msg.length(); i++) {
  			    String letter = String.valueOf(msg.charAt(i));
  			    spawn(letter, new Location(loc.getWorld(), loc.getX() + count, loc.getY(), loc.getZ()), block);
  			    count = count + get(letter) + 1;
  			    if (count > 38) return true;
  			}
  			}
		return true;
	}
	
	public void spawn(String letter, Location loc, Material block) {
		if (letter.equalsIgnoreCase("a")) a(loc, block);
		else if (letter.equals("B")) b(loc, block);
		else if (letter.equals("C")) c(loc, block);
		else if (letter.equals("D")) d(loc, block);
		else if (letter.equalsIgnoreCase("e")) e(loc, block);
		else if (letter.equals("F")) f(loc, block);
		else if (letter.equals("G")) g(loc, block);
		else if (letter.equals("H")) h(loc, block);
		else if (letter.equals("I")) i(loc, block);
		else if (letter.equals("J")) j(loc, block);
		else if (letter.equals("K")) k(loc, block);
		else if (letter.equals("L")) l(loc, block);
		else if (letter.equals("M")) m(loc, block);
		else if (letter.equals("N")) n(loc, block);
		else if (letter.equals("O")) o(loc, block);
		else if (letter.equals("P")) p(loc, block);
		else if (letter.equals("Q")) q(loc, block);
		else if (letter.equals("R")) r(loc, block);
		else if (letter.equalsIgnoreCase("s")) s(loc, block);
		else if (letter.equals("T")) t(loc, block);
		else if (letter.equals("U")) u(loc, block);
		else if (letter.equals("V")) v(loc, block);
		else if (letter.equals("W")) w(loc, block);
		else if (letter.equals("X")) x(loc, block);
		else if (letter.equals("Y")) y(loc, block);
		else if (letter.equalsIgnoreCase("Z")) z(loc, block);
		
		else if (letter.equals("b")) lowb(loc, block);
		else if (letter.equals("c")) lowc(loc, block);
		else if (letter.equals("d")) lowd(loc, block);
		else if (letter.equals("f")) lowf(loc, block);
		else if (letter.equals("g")) lowg(loc, block);
		else if (letter.equals("h")) lowh(loc, block);
		else if (letter.equals("i")) lowi(loc, block);
		else if (letter.equals("j")) lowj(loc, block);
		else if (letter.equals("k")) lowk(loc, block);
		else if (letter.equals("l")) lowl(loc, block);
		else if (letter.equals("m")) lowm(loc, block);
		else if (letter.equals("n")) lown(loc, block);
		else if (letter.equals("o")) lowo(loc, block);
		else if (letter.equals("p")) lowp(loc, block);
		else if (letter.equals("q")) lowq(loc, block);
		else if (letter.equals("r")) lowr(loc, block);
		else if (letter.equals("t")) lowt(loc, block);
		else if (letter.equals("u")) lowu(loc, block);
		else if (letter.equals("v")) lowv(loc, block);
		else if (letter.equals("w")) loww(loc, block);
		else if (letter.equals("x")) lowx(loc, block);
		else if (letter.equals("y")) lowy(loc, block);
		
		else if (letter.equals("1")) num1(loc, block);
		else if (letter.equals("2")) num2(loc, block);
		else if (letter.equals("3")) num3(loc, block);
		else if (letter.equals("4")) num4(loc, block);
		else if (letter.equals("5")) num5(loc, block);
		else if (letter.equals("6")) num6(loc, block);
		else if (letter.equals("7")) num7(loc, block);
		else if (letter.equals("8")) num8(loc, block);
		else if (letter.equals("9")) num9(loc, block);
		else if (letter.equals("0")) num0(loc, block);
		else if (letter.equals("!")) sym1(loc, block);
		else if (letter.equals("?")) sym2(loc, block);
		else if (letter.equals(":")) sym3(loc, block);
		else if (letter.equals("#")) sym4(loc, block);
		else if (letter.equals("<")) sym5(loc, block);
		else if (letter.equals(">")) sym6(loc, block);
		else if (letter.equals("*")) sym7(loc, block);
		else if (letter.equals("^")) sym8(loc, block);
		else if (letter.equals("(")) sym9(loc, block);
		else if (letter.equals(")")) sym10(loc, block);
		else if (letter.equals("-")) sym11(loc, block);
		else if (letter.equals("_")) sym12(loc, block);
		else if (letter.equals("+")) sym13(loc, block);
		else if (letter.equals("=")) sym14(loc, block);
	}
	
	public int get(String letter) {
		if (letter.equalsIgnoreCase("a")) return 4;
		if (letter.equals("B")) return 3;
		if (letter.equals("C")) return 3;
		if (letter.equals("D")) return 3;
		if (letter.equalsIgnoreCase("e")) return 3;
		if (letter.equals("F")) return 3;
		if (letter.equals("G")) return 4;
		if (letter.equals("H")) return 4;
		if (letter.equals("I")) return 3;
		if (letter.equals("J")) return 4;
		if (letter.equals("K")) return 3;
		if (letter.equals("L")) return 3;
		if (letter.equals("M")) return 5;
		if (letter.equals("N")) return 4;
		if (letter.equals("O")) return 4;
		if (letter.equals("P")) return 4;
		if (letter.equals("Q")) return 4;
		if (letter.equals("r")) return 3;
		if (letter.equalsIgnoreCase("s")) return 3;
		if (letter.equals("T")) return 3;
		if (letter.equals("U")) return 4;
		if (letter.equals("V")) return 3;
		if (letter.equals("W")) return 5;
		if (letter.equals("X")) return 3;
		if (letter.equals("Y")) return 3;
		if (letter.equalsIgnoreCase("z")) return 3;
		
		//TODO a
		if (letter.equals("b")) return 3;
		if (letter.equals("c")) return 3;
		if (letter.equals("d")) return 3;
		//TODO e
		if (letter.equals("f")) return 2;
		if (letter.equals("g")) return 3;
		if (letter.equals("h")) return 3;
		if (letter.equals("i")) return 1;
		if (letter.equals("j")) return 3;
		if (letter.equals("k")) return 3;
		if (letter.equals("l")) return 3;
		if (letter.equals("m")) return 5;
		if (letter.equals("n")) return 3;
		if (letter.equals("o")) return 4;
		if (letter.equals("p")) return 3;
		if (letter.equals("q")) return 3;
		if (letter.equals("r")) return 3;
		if (letter.equals("t")) return 3;
		if (letter.equals("u")) return 4;
		if (letter.equals("v")) return 3;
		if (letter.equals("w")) return 5;
		if (letter.equals("x")) return 3;
		if (letter.equals("y")) return 3;
		
		if (letter.equals("1")) return 3;
		if (letter.equals("2")) return 4;
		if (letter.equals("3")) return 3;
		if (letter.equals("4")) return 3;
		if (letter.equals("5")) return 3;
		if (letter.equals("6")) return 3;
		if (letter.equals("7")) return 3;
		if (letter.equals("8")) return 3;
		if (letter.equals("9")) return 3;
		if (letter.equals("0")) return 3;
		if (letter.equals("!")) return 1;
		if (letter.equals("?")) return 3;
		if (letter.equals(":")) return 1;
		if (letter.equals("#")) return 5;
		if (letter.equals("<")) return 3;
		if (letter.equals(">")) return 3;
		if (letter.equals("*")) return 3;
		if (letter.equals("^")) return 3;
		if (letter.equals("(")) return 2;
		if (letter.equals(")")) return 2;
		if (letter.equals("-")) return 2;
		if (letter.equals("_")) return 2;
		if (letter.equals("+")) return 3;
		if (letter.equals("=")) return 3;
		return 0;
	}
	
	public void a(Location loc, Material block) {
		//Left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		//Right
		set(loc, block, 3, 0);
		set(loc, block, 3, 1);
		set(loc, block, 3, 2);
		set(loc, block, 3, 3);
		//Top
		set(loc, block, 1, 4);
		set(loc, block, 2, 4);
		//Center
		set(loc, block, 1, 2);
		set(loc, block, 2, 2);
	}
	
	public void b(Location loc, Material block) {
		//Left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//center
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//right
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
	}
	
	public void c(Location loc, Material block) {
		//Left
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		//center
		set(loc, block, 1, 0);
		set(loc, block, 1, 4);
		//right
		set(loc, block, 2, 0);
		set(loc, block, 2, 4);
	}
	
	public void d(Location loc, Material block) {
		//Left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//center
		set(loc, block, 1, 0);
		set(loc, block, 1, 4);
		//right
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
	}
	
	public void e(Location loc, Material block) {
		//Left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//center
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//right
		set(loc, block, 2, 0);
		set(loc, block, 2, 2);
		set(loc, block, 2, 4);
	}
	
	public void f(Location loc, Material block) {
		//Left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//center
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//right
		set(loc, block, 2, 2);
		set(loc, block, 2, 4);
	}
	
	public void g(Location loc, Material block) {
		//Left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 4);
		set(loc, block, 2, 2);
		//right
		set(loc, block, 3, 0);
		set(loc, block, 3, 1);
		set(loc, block, 3, 2);
		set(loc, block, 3, 4);
	}
	
	public void h(Location loc, Material block) {
		//Left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 2);
		//right
		set(loc, block, 3, 0);
		set(loc, block, 3, 1);
		set(loc, block, 3, 2);
		set(loc, block, 3, 3);
		set(loc, block, 3, 4);
	}
	
	public void i(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 1);
		set(loc, block, 1, 2);
		set(loc, block, 1, 3);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 4);
	}
	
	public void j(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
		//next
		set(loc, block, 3, 4);
	}
	
	public void k(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void l(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		//next
		set(loc, block, 2, 0);
	}
	
	public void m(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 3);
		//next
		set(loc, block, 3, 4);
		//next
		set(loc, block, 4, 0);
		set(loc, block, 4, 1);
		set(loc, block, 4, 2);
		set(loc, block, 4, 3);
	}
	
	public void n(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 3);
		//next
		set(loc, block, 3, 0);
		set(loc, block, 3, 1);
		set(loc, block, 3, 2);
		set(loc, block, 3, 3);
		set(loc, block, 3, 4);
	}
	
	public void o(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 4);
		//next
		set(loc, block, 3, 1);
		set(loc, block, 3, 2);
		set(loc, block, 3, 3);
	}
	
	public void p(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void q(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
		//next
		set(loc, block, 3, 0);
	}
	
	public void r(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 1);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void s(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 4);
	}
	
	public void t(Location loc, Material block) {
		//left
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 1);
		set(loc, block, 1, 2);
		set(loc, block, 1, 3);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 4);
	}

	public void u(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		//next
		set(loc, block, 2, 0);
		//next
		set(loc, block, 3, 1);
		set(loc, block, 3, 2);
		set(loc, block, 3, 3);
		set(loc, block, 3, 4);
	}
	
	public void v(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		//next
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void w(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		//next
		set(loc, block, 2, 1);
		//next
		set(loc, block, 3, 0);
		//next
		set(loc, block, 4, 1);
		set(loc, block, 4, 2);
		set(loc, block, 4, 3);
		set(loc, block, 4, 4);
	}
	
	public void x(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void y(Location loc, Material block) {
		//left
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 1);
		//next
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void z(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	//TODO a
	public void lowb(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
	}
	
	public void lowc(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 3);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 3);
	}
	public void lowd(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	//TODO e
	public void lowf(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 1);
		set(loc, block, 1, 3);
	}
	
	public void lowg(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void lowh(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
	}
	
	public void lowi(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 4);
	}
	
	public void lowj(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		//next
		set(loc, block, 1, 0);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 4);
	}
	
	public void lowk(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		//next
		set(loc, block, 1, 1);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 2);
	}
	
	public void lowl(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 0);
		//next
		set(loc, block, 2, 0);
	}
	
	public void lowm(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		//next
		set(loc, block, 1, 3);
		//next
		set(loc, block, 2, 2);
		//next
		set(loc, block, 3, 3);
		//next
		set(loc, block, 4, 0);
		set(loc, block, 4, 1);
		set(loc, block, 4, 2);
	}
	
	public void lown(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
	}
	
	public void lowo(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 3);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 3);
		//next
		set(loc, block, 3, 1);
		set(loc, block, 3, 2);
	}
	
	public void lowp(Location loc, Material block) {
	set(loc, block, 0, 0);
	set(loc, block, 0, 1);
	set(loc, block, 0, 2);
	set(loc, block, 0, 3);
	//next
	set(loc, block, 1, 1);
	set(loc, block, 1, 3);
	//next
	set(loc, block, 2, 1);
	set(loc, block, 2, 2);
	set(loc, block, 2, 3);
	}
	
	public void lowq(Location loc, Material block) {
	set(loc, block, 0, 1);
	set(loc, block, 0, 2);
	set(loc, block, 0, 3);
	//next
	set(loc, block, 1, 1);
	set(loc, block, 1, 3);
	//next
	set(loc, block, 2, 0);
	set(loc, block, 2, 1);
	set(loc, block, 2, 2);
	set(loc, block, 2, 3);
	}
	
	public void lowr(Location loc, Material block) {
	set(loc, block, 0, 0);
	set(loc, block, 0, 1);
	set(loc, block, 0, 2);
	set(loc, block, 0, 3);
	//next
	set(loc, block, 1, 2);
	//next
	set(loc, block, 2, 1);
	set(loc, block, 2, 2);
	}
	//TODO s
	public void lowt(Location loc, Material block) {
	set(loc, block, 0, 2);
	//next
	set(loc, block, 1, 0);
	set(loc, block, 1, 1);
	set(loc, block, 1, 2);
	set(loc, block, 1, 3);
	//next
	set(loc, block, 2, 2);
	}
	
	public void lowu(Location loc, Material block) {
	set(loc, block, 0, 1);
	set(loc, block, 0, 2);
	//next
	set(loc, block, 1, 0);
	//next
	set(loc, block, 2, 0);
	//next
	set(loc, block, 3, 1);
	set(loc, block, 3, 2);
	}
	
	public void lowv(Location loc, Material block) {
	set(loc, block, 0, 1);
	set(loc, block, 0, 2);
	//next
	set(loc, block, 1, 0);
	//next
	set(loc, block, 2, 1);
	set(loc, block, 2, 2);
	}
	
	public void loww(Location loc, Material block) {
	set(loc, block, 0, 1);
	set(loc, block, 0, 2);
	set(loc, block, 0, 3);
	//next
	set(loc, block, 1, 0);
	//next
	set(loc, block, 2, 1);
	set(loc, block, 2, 2);
	//next
	set(loc, block, 3, 0);
	//next
	set(loc, block, 4, 1);
	set(loc, block, 4, 2);
	set(loc, block, 4, 3);
	}
	
	public void lowx(Location loc, Material block) {
	set(loc, block, 0, 0);
	set(loc, block, 0, 2);
	//next
	set(loc, block, 1, 1);
	//next
	set(loc, block, 2, 0);
	set(loc, block, 2, 2);
	}
	
	public void lowy(Location loc, Material block) {
	set(loc, block, 0, 0);
	set(loc, block, 0, 2);
	set(loc, block, 0, 3);
	set(loc, block, 0, 4);
	//next
	set(loc, block, 1, 0);
	set(loc, block, 1, 2);
	//next
	set(loc, block, 2, 0);
	set(loc, block, 2, 1);
	set(loc, block, 2, 2);
	set(loc, block, 2, 3);
	set(loc, block, 2, 4);
	}
	//TODO Z

	
	
	public void num1(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 1);
		set(loc, block, 1, 2);
		set(loc, block, 1, 3);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
	}
	
	public void num2(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 1);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 2);
		set(loc, block, 2, 4);
		//next
		set(loc, block, 3, 0);
		set(loc, block, 3, 3);
	}
	
	public void num3(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 2);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void num4(Location loc, Material block) {
		//left
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void num5(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 4);
	}
	
	public void num6(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 4);
	}
	
	public void num7(Location loc, Material block) {
		//left
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 1);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void num8(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void num9(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void num0(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 1);
		set(loc, block, 2, 2);
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void sym1(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		set(loc, block, 0, 4);
	}
	
	public void sym2(Location loc, Material block) {
		//left
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 2);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 3);
		set(loc, block, 2, 4);
	}
	
	public void sym3(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 3);
	}
	
	public void sym4(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 1);
		set(loc, block, 1, 2);
		set(loc, block, 1, 3);
		set(loc, block, 1, 4);
		//next
		set(loc, block, 2, 1);
		set(loc, block, 2, 3);
		//next
		set(loc, block, 3, 0);
		set(loc, block, 3, 1);
		set(loc, block, 3, 2);
		set(loc, block, 3, 3);
		set(loc, block, 3, 4);
		//next
		set(loc, block, 4, 1);
		set(loc, block, 4, 3);
	}
	
	public void sym5(Location loc, Material block) {
		//left
		set(loc, block, 0, 2);
		//next
		set(loc, block, 1, 1);
		set(loc, block, 1, 3);
		//next
		set(loc, block, 2, 0);
		set(loc, block, 2, 4);
	}
	
	public void sym6(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 1);
		set(loc, block, 1, 3);
		//next
		set(loc, block, 2, 2);
	}
	
	public void sym7(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 1);
		set(loc, block, 2, 3);
	}
	
	public void sym8(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		//next
		set(loc, block, 1, 2);
		//next
		set(loc, block, 2, 1);
	}
	
	public void sym9(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 2);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 0);
		set(loc, block, 1, 4);
	}
	
	public void sym10(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		set(loc, block, 0, 4);
		//next
		set(loc, block, 1, 1);
		set(loc, block, 1, 2);
		set(loc, block, 1, 3);
	}
	
	public void sym11(Location loc, Material block) {
		//left
		set(loc, block, 0, 2);
		//next
		set(loc, block, 1, 2);
	}
	
	public void sym12(Location loc, Material block) {
		//left
		set(loc, block, 0, 0);
		//next
		set(loc, block, 1, 0);
	}
	
	public void sym13(Location loc, Material block) {
		//left
		set(loc, block, 0, 2);
		//next
		set(loc, block, 1, 1);
		set(loc, block, 1, 2);
		set(loc, block, 1, 3);
		//next
		set(loc, block, 2, 2);
	}
	
	public void sym14(Location loc, Material block) {
		//left
		set(loc, block, 0, 1);
		set(loc, block, 0, 3);
		//next
		set(loc, block, 1, 1);
		set(loc, block, 1, 3);
	}
	
	public void set(Location loc, Material block, int x, int y) {
		new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y, loc.getZ()).getBlock().setType(block);
	}
	
}