package me.Mark.pocketLink;

import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class PocketLink extends PluginBase {

	static Server inst;
	
    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "PocketLink Enabled!");
        this.getServer().getPluginManager().registerEvents(new Listiner(this), this);
        inst = getServer();
        
        try {
			Client.start();
		} catch (Exception e1) {}
        
    }
    
    public static void broadcast(String msg) {
    	msg = msg.replace("&", "§");
    	inst.getLogger().info(msg);
    	Map<UUID, Player> players = inst.getOnlinePlayers();
    	for (Entry<UUID, Player> entry : players.entrySet()) {
    		Player p = entry.getValue();
    		p.sendMessage(msg);
    	}
    }

}