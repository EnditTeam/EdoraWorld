package fr.endit.edoraworld.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

import fr.endit.edoraworld.EdoraWorldExpectPlatform;

public class EdoraWorldExpectPlatformImpl {
    /**
     * This is our actual method to {@link EdoraWorldExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
