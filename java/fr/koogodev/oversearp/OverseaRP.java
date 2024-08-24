package fr.koogodev.oversearp;

import fr.koogodev.oversearp.SkriptUtils.SkriptUtils;
import fr.koogodev.oversearp.commands.MeCommand;
import fr.koogodev.oversearp.listeners.MeListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class OverseaRP extends JavaPlugin {
    static HashMap<UUID, ArmorStand> armorStandHashMap = new HashMap<UUID, ArmorStand>();

    @Override
    public void onEnable() {
        SkriptUtils skriptUtils = new SkriptUtils();
        getCommand("me").setExecutor(new MeCommand(this));
        Bukkit.getPluginManager().registerEvents(new MeListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<UUID, ArmorStand> gethashMap(){
        return armorStandHashMap;
    }
}
