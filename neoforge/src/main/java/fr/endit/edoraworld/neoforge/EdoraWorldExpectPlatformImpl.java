package fr.endit.edoraworld.neoforge;

import java.nio.file.Path;

import fr.endit.edoraworld.EdoraWorldExpectPlatform;
import net.neoforged.fml.loading.FMLPaths;

public class EdoraWorldExpectPlatformImpl {
    /**
     * This is our actual method to
     * {@link EdoraWorldExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
