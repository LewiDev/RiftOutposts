package me.lewidev.rift.listeners;

import me.lewidev.rift.Outposts;
import me.lewidev.rift.events.OutpostAttackEvent;
import me.lewidev.rift.events.OutpostClaimingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class onOutpostClaiming implements Listener {

    private Outposts javaPlugin;

    public onOutpostClaiming(Outposts javaPlugin) {
        this.javaPlugin = javaPlugin;

        javaPlugin.getServer().getPluginManager().registerEvents(this, javaPlugin);
    }

    @EventHandler
    public void onOutpostClaiming(OutpostClaimingEvent event) {
        // send claiming mesasge
        // begin to claim
    }

}
