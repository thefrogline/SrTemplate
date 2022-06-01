package sr.template;

import co.aikar.commands.PaperCommandManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import sr.template.commands.MainCMD;
import sr.template.commands.SetSpawnCMD;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    PaperCommandManager commandManager;
    private File customConfigFile;
    private FileConfiguration customConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic here
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new MainCMD(this));
        commandManager.registerCommand(new SetSpawnCMD(this));
        createCustomConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        customConfig= new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
