package me.lewidev.rift.utils;

import lombok.Getter;
import me.lewidev.rift.Outposts;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    private Outposts javaPlugin;

    @Getter private YamlConfiguration messageFile;
    @Getter private YamlConfiguration outpostsFile;
    @Getter private YamlConfiguration configFile;


    public FileHandler(Outposts javaPlugin) {
        this.javaPlugin = javaPlugin;
        this.messageFile = loadFile("messages.yml");
        this.outpostsFile = loadFile("outposts.yml");
        this.configFile = loadFile("config.yml");
    }

    public void saveAll() {
        saveFile("message.yml");
        saveFile("outposts.yml");
        saveFile("config.yml");
    }

    public void createFile(String name) {
        if(!javaPlugin.getDataFolder().exists()) {
            javaPlugin.getDataFolder().mkdirs();
        }
        File file = new File(javaPlugin.getDataFolder(), name);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Cannot Create File! Error");
                return;
            }
        }
    }

    public YamlConfiguration loadFile(String filename) {
        File file = new File(javaPlugin.getDataFolder(), filename);
        YamlConfiguration modifyFile = YamlConfiguration.loadConfiguration(file);
        return modifyFile;
    }

    public void saveFile(String filename) {
        File file = new File(javaPlugin.getDataFolder(), filename);
        try {
            loadFile(filename).save(file);
        } catch (IOException e) {
            System.out.println("Cannot Save File! Error");
            return;
        }
    }








}
