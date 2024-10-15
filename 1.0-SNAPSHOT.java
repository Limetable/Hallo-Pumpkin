package de.joyserstudios.halloween;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class halloween extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("-----------------------");
        getLogger().info("Halloween is activated!");
        getLogger().info("Version: 1.0-SH");
        getLogger().info("-----------------------");
    }

    @Override
    public void onDisable() {
        getLogger().info("-------------------------");
        getLogger().info("Halloween is deactivated!");
        getLogger().info("---------------------Bye!");
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();

        // Проверяем, что это не игрок
        if (!(entity instanceof Player)) {
            // Создаем тыкву и одеваем ее на голову моба
            ItemStack pumpkin = new ItemStack(Material.CARVED_PUMPKIN);
            entity.getEquipment().setHelmet(pumpkin);
        }
    }


}
