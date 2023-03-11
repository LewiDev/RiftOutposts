package me.lewidev.rift.instance;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.util.BoundingBox;

@Getter
@Setter
public class Outpost {

    @Getter
    @Setter
    private Team attackingTeam;
    private Team currentTeam;
    private Location corner1;
    private Location corner2;
    private String outpostName;
    private double outpostBoost;
     //TODO add team data storage with getter and setter (waiting on core)

    public Outpost() {}

    public Outpost(String outpostName, Double outpostBoost, String worldName, Double corner1x, Double corner1y, Double corner1z, Double corner2x, Double corner2y, Double corner2z) {
        this.corner1 = new Location(Bukkit.getWorld(worldName), corner1x, corner1y, corner1z);
        this.corner2 = new Location(Bukkit.getWorld(worldName), corner2x, corner2y, corner2z);
        this.outpostName = outpostName;
        this.outpostBoost = outpostBoost;

    }

}
