package me.lewidev.rift;

import lombok.Getter;
import me.lewidev.rift.listeners.onOutpostAttack;
import me.lewidev.rift.listeners.onOutpostClaim;
import me.lewidev.rift.listeners.onOutpostClaiming;
import me.lewidev.rift.listeners.onPlayerMove;
import me.lewidev.rift.utils.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Outposts extends JavaPlugin {

    @Getter private FileHandler fileHandler;
    @Getter private OutpostsHandler outpostsHandler;
    @Getter private AttackingHandler attackingHandler;
    @Getter private ClaimingHandler claimingHandler;
    @Getter private ClaimHandler claimHandler;

    @Override
    public void onEnable() {
        loadUtils();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadUtils() {
        fileHandler = new FileHandler(this);
        outpostsHandler = new OutpostsHandler(this);
        claimHandler = new ClaimHandler(this);
        claimingHandler = new ClaimingHandler(this);
        attackingHandler = new AttackingHandler(this);
    }

    private void registerEvents() {
        new onPlayerMove(this);
        new onOutpostClaiming(this);
        new onOutpostClaim(this);
        new onOutpostAttack(this);
    }
}
