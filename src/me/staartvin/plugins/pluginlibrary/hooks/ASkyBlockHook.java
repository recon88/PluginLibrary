package me.staartvin.plugins.pluginlibrary.hooks;

import com.wasteofplastic.askyblock.ASkyBlock;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import me.staartvin.plugins.pluginlibrary.Library;

import java.util.UUID;

/**
 * ASkyBlock library,
 * <a href="https://www.spigotmc.org/resources/askyblock.1220/">link</a>.
 * <p>
 * 
 * @author Staartvin
 * 
 */
public class ASkyBlockHook extends LibraryHook {

    private ASkyBlock aSkyBlock;

	/*
	 * (non-Javadoc)
	 * 
	 * @see me.staartvin.plugins.pluginlibrary.hooks.LibraryHook#isAvailable()
	 */
	@Override
	public boolean isAvailable() {
		return this.getPlugin().getServer().getPluginManager().isPluginEnabled(Library.ASKYBLOCK.getPluginName());
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

        aSkyBlock = (ASkyBlock) this.getPlugin().getServer().getPluginManager()
                .getPlugin(Library.ASKYBLOCK.getPluginName());

        return aSkyBlock != null;
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
