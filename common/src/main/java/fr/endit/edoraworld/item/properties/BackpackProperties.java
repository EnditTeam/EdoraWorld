package fr.endit.edoraworld.item.properties;

import java.util.UUID;

public class BackpackProperties {
    private final int nbSlots;
    private final UUID nationID;

    public BackpackProperties(int nbSlots, UUID nationID) {
        this.nbSlots = nbSlots;
        this.nationID = nationID;
    }

    public BackpackProperties(int nbSlots) {
        this.nbSlots = nbSlots;
        this.nationID = null;
    }

    public int getNbSlots() {
        return nbSlots;
    }

    public UUID getNationID() {
        return nationID;
    }
}
