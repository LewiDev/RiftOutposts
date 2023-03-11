package me.lewidev.rift.listeners;

import me.lewidev.rift.Outposts;
import me.lewidev.rift.events.OutpostAttackEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class onOutpostAttack implements Listener {

    private Outposts javaPlugin;

    public onOutpostAttack(Outposts javaPlugin) {
        this.javaPlugin = javaPlugin;

        javaPlugin.getServer().getPluginManager().registerEvents(this, javaPlugin);
    }

    @EventHandler
    public void onOutpostAttack(OutpostAttackEvent event) {
        // send def team a message
        // begin to attack
    }

}
