package sr.template.commands;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import sr.template.Main;
import sr.template.utilities.Locations;

@CommandPermission("operator")
@CommandAlias("setspawn")
@RequiredArgsConstructor
public class SetSpawnCMD extends BaseCommand {

    private @NonNull Main instance;

    @CommandPermission("operator")
    @Subcommand("spawn")
    public void spawn(Player p) {
        Locations.saveLoc(instance, p, "spawn");
    }
}
