package fr.endit.edoraworld;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigurationHandler {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);

    public static class General {
        public ForgeConfigSpec.ConfigValue<List<? extends String>> testList;

        General(ForgeConfigSpec.Builder builder) {
            builder.push("general");

            testList = builder
                    .comment("This is just a testlist lol")
                    .define("Test List", Arrays.asList("meow1", "meow2"));
        }
    }

    public static final ForgeConfigSpec spec = BUILDER.build();
}
