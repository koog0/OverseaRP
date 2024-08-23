package fr.koogodev.oversearp_legal.listeners;

import fr.koogodev.oversearp_legal.OverseaRP_Legal;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.UUID;

public class MeListener implements Listener {
    private final OverseaRP_Legal overseaRPLegal;

    public MeListener(OverseaRP_Legal overseaRPLegal) {
        this.overseaRPLegal = overseaRPLegal;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        HashMap<UUID, ArmorStand> hashMap = overseaRPLegal.gethashMap();
        if (hashMap.containsKey(e.getPlayer().getUniqueId())){
            ArmorStand armorStand = hashMap.get(e.getPlayer().getUniqueId());
            armorStand.teleport(e.getPlayer().getLocation());
        }
    }
}
