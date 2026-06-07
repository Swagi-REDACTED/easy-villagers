package de.maxhenkel.easyvillagers.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;

public class ClientContainerHelper {
    public static Level getLevel() {
        return Minecraft.getInstance().level;
    }
}
