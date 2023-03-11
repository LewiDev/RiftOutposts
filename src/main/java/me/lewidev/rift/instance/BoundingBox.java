package me.lewidev.rift.instance;


import org.bukkit.Location;

public class BoundingBox extends org.bukkit.util.BoundingBox {

    public BoundingBox(Location corner1, Location corner2) {
        new org.bukkit.util.BoundingBox(corner1.getX(), corner1.getY(), corner1.getZ(), corner2.getX(), corner2.getY(), corner2.getZ());
    }

}
