package me.staartvin.plugins.pluginlibrary.hooks;

import com.wasteofplastic.acidisland.ASkyBlock;
import com.wasteofplastic.acidisland.ASkyBlockAPI;
import me.staartvin.plugins.pluginlibrary.Library;

import java.util.UUID;

/**
 * AcidIsland library,
 * <a href="https://www.spigotmc.org/resources/acidisland.581/">link</a>.
 * <p>
 * 
 * @author Staartvin
 * 
 */
public class AcidIslandHook extends LibraryHook {

    private ASkyBlock acidIsland;

	/*
	 * (non-Javadoc)
	 * 
	 * @see me.staartvin.plugins.pluginlibrary.hooks.LibraryHook#isAvailable()
	 */
	@Override
	public boolean isAvailable() {
        return this.getPlugin().getServer().getPluginManager().isPluginEnabled(Library.ACIDISLAND.getPluginName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see me.staartvin.plugins.pluginlibrary.hooks.LibraryHook#hook()
	 */
	@Override
	public boolean hook() {

        if (!isAvailable())
            return false;

        acidIsland = (ASkyBlock) this.getPlugin().getServer().getPluginManager()
                .getPlugin(Library.ACIDISLAND.getPluginName());

        return acidIsland != null;
	}


    /**
     * Get the level of the island of a player. Returns 0 if the player does not have an island.
     * @param uuid UUID of the player
     * @return level of the island.
     */
    public int getIslandLevel(final UUID uuid) {
        if (!isAvailable())
            return -1;

        return ASkyBlockAPI.getInstance().getIslandLevel(uuid);
    }

    /**
     * Check whether a player has an island.
     * @param uuid UUID of the player
     * @return true if the player has an island, false otherwise.
     */
    public boolean hasIsland(final UUID uuid) {
        if (!isAvailable())
            return false;

        return ASkyBlockAPI.getInstance().hasIsland(uuid);
    }

}
