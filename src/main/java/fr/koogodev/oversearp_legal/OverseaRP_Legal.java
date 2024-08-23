package fr.koogodev.oversearp_legal;

import fr.koogodev.oversearp_legal.commands.MeCommand;
import fr.koogodev.oversearp_legal.listeners.MeListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class OverseaRP_Legal extends JavaPlugin {
    static HashMap<UUID, ArmorStand> armorStandHashMap = new HashMap<UUID, ArmorStand>();

    @Override
    public void onEnable() {
        getCommand("me").setExecutor(new MeCommand(this));
        Bukkit.getPluginManager().registerEvents(new MeListener(this), this);
    }

    @Override
    public void onDisable() {
    }

    public HashMap<UUID, ArmorStand> gethashMap(){
        return armorStandHashMap;
    }
}
