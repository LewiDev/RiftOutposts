package me.lewidev.rift.utils;

import lombok.Getter;
import me.lewidev.rift.Outposts;
import me.lewidev.rift.instance.Outpost;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.BoundingBox;

public class OutpostsHandler {

    private Outposts javaPlugin;

    private ConfigurationSection outpostsConfig;
    private ConfigurationSection messages;

    @Getter private Outpost moneyOutpost;
    @Getter private Outpost spawnerOutpost;

    @Getter private BoundingBox moneyOutpostsRegion;
    @Getter private BoundingBox spawnerOutpostsRegion;

    public OutpostsHandler(Outposts javaPlugin) {
        this.javaPlugin = javaPlugin;

        this.outpostsConfig = javaPlugin.getFileHandler().getOutpostsFile().getConfigurationSection("outposts");
        this.messages = javaPlugin.getFileHandler().getMessageFile().getConfigurationSection("outpost-messages");

        this.moneyOutpost = createMoneyOutpost();
        this.spawnerOutpost = createSpawnerOutpost();

        this.moneyOutpostsRegion = getOutpostRegion(moneyOutpost);
        this.spawnerOutpostsRegion = getOutpostRegion(spawnerOutpost);
    }

    private Outpost createMoneyOutpost() {
        ConfigurationSection moneyOutpostDetails = outpostsConfig.getConfigurationSection("money");
        if(moneyOutpostDetails == null) {
            System.out.println("Cannot Load Money Outpost Details! Error");
            return null;
        }
        return new Outpost(
            moneyOutpostDetails.getName(),
            moneyOutpostDetails.getDouble("moneyBoost"),
            moneyOutpostDetails.getString("outpostWorld"),
            moneyOutpostDetails.getDouble("corner1-x"),
            moneyOutpostDetails.getDouble("corner1-y"),
            moneyOutpostDetails.getDouble("corner1-z"),
            moneyOutpostDetails.getDouble("corner2-x"),
            moneyOutpostDetails.getDouble("corner2-y"),
            moneyOutpostDetails.getDouble("corner2-z")
        );
    }

    private Outpost createSpawnerOutpost() {
        ConfigurationSection spawnerOutpostDetails = outpostsConfig.getConfigurationSection("spawner");
        if(spawnerOutpostDetails == null) {
            System.out.println("Cannot Load Money Outpost Details! Error");
            return null;
        }
        return new Outpost(
                spawnerOutpostDetails.getName(),
                spawnerOutpostDetails.getDouble("moneyBoost"),
                spawnerOutpostDetails.getString("outpostWorld"),
                spawnerOutpostDetails.getDouble("corner1-x"),
                spawnerOutpostDetails.getDouble("corner1-y"),
                spawnerOutpostDetails.getDouble("corner1-z"),
                spawnerOutpostDetails.getDouble("corner2-x"),
                spawnerOutpostDetails.getDouble("corner2-y"),
                spawnerOutpostDetails.getDouble("corner2-z")
        );
    }

    private BoundingBox getOutpostRegion(Outpost outpost) {
        return new me.lewidev.rift.instance.BoundingBox(outpost.getCorner1(), outpost.getCorner2());
    }

}
