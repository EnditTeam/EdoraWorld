package fr.endit.edoraworld.enUwUm;

import lombok.*;
import net.minecraft.network.chat.Component;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Nation {
    Kawan("Kawan", "Loc'na'ko", "Dakara", Component.translatable("nations.edoraworld.kawan.description"));
    /*
     * TODO: complete other nations
     * Othala("Othala"),
     * Druag("Druag"),
     * Hajim("Hajim");
     */

    private final String name;
    private final String origin;
    private final String capital;
    private final Component description;
}
