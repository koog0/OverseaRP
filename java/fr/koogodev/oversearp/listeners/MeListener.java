package fr.koogodev.oversearp.listeners;

import fr.koogodev.oversearp.OverseaRP;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.UUID;

public class MeListener implements Listener {
    private final OverseaRP overseaRP;

    public MeListener(OverseaRP overseaRPLegal) {
        this.overseaRP = overseaRPLegal;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        HashMap<UUID, ArmorStand> hashMap = overseaRP.gethashMap();
        if (hashMap.containsKey(e.getPlayer().getUniqueId())){
            ArmorStand armorStand = hashMap.get(e.getPlayer().getUniqueId());
            armorStand.teleport(e.getPlayer().getLocation());
        }
    }
}
