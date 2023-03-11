package me.lewidev.rift.listeners;

import me.lewidev.rift.Outposts;
import me.lewidev.rift.events.OutpostAttackEvent;
import me.lewidev.rift.events.OutpostClaimEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class onOutpostClaim implements Listener {

    private Outposts javaPlugin;

    public onOutpostClaim(Outposts javaPlugin) {
        this.javaPlugin = javaPlugin;

        javaPlugin.getServer().getPluginManager().registerEvents(this, javaPlugin);
    }

    @EventHandler
    public void onOutpostClaim(OutpostClaimEvent event) {
        // send claim message
        // claim functions
    }

}
