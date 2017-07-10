package me.foodle.ccommands;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CCommands extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this,this);
    }
    @EventHandler
    public void command(PlayerCommandPreprocessEvent e){
        for(String s : getConfig().getKeys(false)){
            if(e.getMessage().equalsIgnoreCase("/"+s)) {
                for(String msg : getConfig().getStringList(s+".messages")) {
                    e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',msg));
                }
            }
        }
    }
}
