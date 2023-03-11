package me.lewidev.rift.listeners;

import me.lewidev.rift.Outposts;
import me.lewidev.rift.events.OutpostAttackEvent;
import me.lewidev.rift.events.OutpostClaimingEvent;
import me.lewidev.rift.instance.Outpost;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onPlayerMove implements Listener {

    private Outposts javaPlugin;

    public onPlayerMove(Outposts javaPlugin) {
        this.javaPlugin = javaPlugin;

        javaPlugin.getServer().getPluginManager().registerEvents(this, javaPlugin);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();


        if(!(player.getWorld().getName() == javaPlugin.getOutpostsHandler().getMoneyOutpost().getCorner1().getWorld().getName())) return;


        if(javaPlugin.getOutpostsHandler().getMoneyOutpostsRegion().contains(player.getLocation().toVector())) {

            Outpost outpost = javaPlugin.getOutpostsHandler().getMoneyOutpost();

            if(outpost.getCurrentTeam() == null) {
                OutpostClaimingEvent customEvent = new OutpostClaimingEvent(outpost, outpost.getAttackingTeam());
                Bukkit.getPluginManager().callEvent(customEvent);
            } else {
                OutpostAttackEvent customEvent = new OutpostAttackEvent(outpost, outpost.getAttackingTeam(), outpost.getCurrentTeam());
                Bukkit.getPluginManager().callEvent(customEvent);
            }

        } else if(javaPlugin.getOutpostsHandler().getSpawnerOutpostsRegion().contains(player.getLocation().toVector())) {

            Outpost outpost = javaPlugin.getOutpostsHandler().getSpawnerOutpost();

            if(outpost.getCurrentTeam() == null) {
                OutpostClaimingEvent customEvent = new OutpostClaimingEvent(outpost, outpost.getAttackingTeam());
                Bukkit.getPluginManager().callEvent(customEvent);
            } else {
                OutpostAttackEvent customEvent = new OutpostAttackEvent(outpost, outpost.getAttackingTeam(), outpost.getCurrentTeam());
                Bukkit.getPluginManager().callEvent(customEvent);
            }

        }
    }

}
