package fr.endit.edoraworld.forge;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

import fr.endit.edoraworld.EdoraWorldExpectPlatform;

public class EdoraWorldExpectPlatformImpl {
    /**
     * This is our actual method to {@link EdoraWorldExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
