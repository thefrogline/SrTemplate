package sr.template.utilities;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import static co.aikar.commands.ACFBukkitUtil.color;

public class Locations {
    public static void saveLoc(Plugin instance, Player p, String Loc_Name){
        Location i = p.getLocation();
        double x = i.getX();
        double y = i.getY();
        double z = i.getZ();
        String world = i.getWorld().getName();
        float yaw = i.getYaw();
        float pitch = i.getPitch();
        FileConfiguration config = instance.getConfig();
        config.set("Config." + Loc_Name + ".x", x);
        config.set("Config." +  Loc_Name + ".y", y);
        config.set("Config." + Loc_Name + ".z", z);
        config.set("Config." + Loc_Name + ".world", world);
        config.set("Config."  + Loc_Name +".yaw", yaw);
        config.set("Config."+  Loc_Name +".pitch", pitch);
        instance.saveConfig();
        p.sendMessage(color("&e&lSrUtils &8> &ePosicion &f" + Loc_Name + " &eguardada correctamente"));
    }

    public static Location getLoc(Plugin instance,Player p,  String LocName){
        FileConfiguration config = instance.getConfig();
        double x = Double.valueOf(config.getString("Config." + LocName+ ".x"));
        double y = Double.valueOf(config.getString("Config." + LocName+ ".y"));
        double z = Double.valueOf(config.getString("Config." + LocName+ ".z"));
        float yaw = Float.valueOf(config.getString("Config." + LocName+ ".yaw"));
        float pitch = Float.valueOf(config.getString("Config." + LocName +".pitch"));
        World world = instance.getServer().getWorld(config.getString("Config." + LocName +".world"));
        Location Coords = new Location(world, x, y, z, yaw, pitch);
        if(Coords == null){
            p.sendMessage(color("&e&lSrUtils &8> &cHubo un error al obtener la informacion de las coordenadas"));
        }
        return Coords;
    }
}
