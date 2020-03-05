package io.alchemystudio.protocol;

import java.util.UUID;

public class Id {

    private final UUID val;
    private final String stringVal;

    public Id(UUID val) {
        this.val = val;
        this.stringVal = val.toString();
    }

    public String getStringVal() {
        return stringVal;
    }

    public static UUID generateUUID() {
        return UUID.randomUUID();
    }

    public static Id generate() {
        return new Id(Id.generateUUID());
    }

    public UUID getVal() {
        return val;
    }
}
