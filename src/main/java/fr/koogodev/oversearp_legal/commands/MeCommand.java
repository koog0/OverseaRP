package fr.koogodev.oversearp_legal.commands;

import fr.koogodev.oversearp_legal.OverseaRP_Legal;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;


public class MeCommand implements CommandExecutor {

    private final OverseaRP_Legal overseaRPLegal;

    public MeCommand(OverseaRP_Legal overseaRPLegal) {
        this.overseaRPLegal = overseaRPLegal;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg0, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                sender.sendMessage("§c/me <texte>");
            }
            else{
                HashMap<UUID, ArmorStand> hashMap = overseaRPLegal.gethashMap();
                StringBuilder strBuilder = new StringBuilder();
                for (String arg : args) {
                    strBuilder.append(arg);
                    strBuilder.append(" ");
                }

                String str = strBuilder.toString();
                str = str.trim();

                ArmorStand text = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                text.setVisible(false);
                text.setCustomNameVisible(true);
                text.setCustomName("*§b" + str + "*");
                hashMap.put(p.getUniqueId(), text);
                BukkitTask task = new BukkitRunnable(){
                    @Override
                    public void run() {
                        text.remove();
                        hashMap.remove(p.getUniqueId());
                    }
                }.runTaskLater(overseaRPLegal, 20*3);
            }
        }
        return false;
    }
}
