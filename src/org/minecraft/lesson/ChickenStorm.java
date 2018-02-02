package org.minecraft.lesson;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ChickenStorm extends JavaPlugin{
	public static final Logger LOG = Logger.getLogger(ChickenStorm.class.getName());
	private static final int NUM_CHICKENS = 30;
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments){
		if (label.equalsIgnoreCase("chickenstorm")){
			if( sender instanceof Player) {
				executeCommand(sender);
				return true;
			}
		}
		return false;
	}

	public void executeCommand(CommandSender sender) {
		Player me = (Player) sender;
		Location spot = me.getLocation();
		World world = me.getWorld();
		for( int i=0; i < Math.random()*NUM_CHICKENS + 1; i++){
			Location chickenspot = new Location(world, spot.getX(), spot.getY(), spot.getZ());
			Chicken clucky = world.spawn(chickenspot, Chicken.class);
			if( Math.random() < 0.4d){
				clucky.setBaby();
			}{
				clucky.setAdult();
			}
		}
		
		
		Log.info("[chickenstorm] The mod create new chicken");
	}
	
}
