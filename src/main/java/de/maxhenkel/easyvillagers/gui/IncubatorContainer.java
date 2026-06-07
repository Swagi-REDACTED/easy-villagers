package de.maxhenkel.easyvillagers.gui;

import de.maxhenkel.easyvillagers.blocks.ModBlocks;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.block.Block;

public class IncubatorContainer extends VillagerContainerBase {

    @SuppressWarnings("this-escape")
    public IncubatorContainer(int id, Inventory playerInventory, Container inputInventory, Container outputInventory, ContainerLevelAccess access) {
        super(Containers.INCUBATOR_CONTAINER, id, playerInventory, null, access);

        for (int i = 0; i < 4; i++) {
            addSlot(new VillagerIncubateSlot(inputInventory, i, 52 + i * 18, 20));
        }

        for (int i = 0; i < 4; i++) {
            addSlot(new OutputSlot(outputInventory, i, 52 + i * 18, 51));
        }

        addPlayerInventorySlots();
    }

    public IncubatorContainer(int id, Inventory playerInventory) {
        this(id, playerInventory, new net.minecraft.world.SimpleContainer(4), new net.minecraft.world.SimpleContainer(4), net.minecraft.world.inventory.ContainerLevelAccess.NULL);
    }

    public IncubatorContainer(int id, Inventory playerInventory, net.minecraft.core.BlockPos pos) {
        this(id, playerInventory, new net.minecraft.world.SimpleContainer(4), new net.minecraft.world.SimpleContainer(4), net.minecraft.world.inventory.ContainerLevelAccess.create(de.maxhenkel.easyvillagers.util.ClientContainerHelper.getLevel(), pos));
    }

    @Override
    public Block getBlock() {
        return ModBlocks.INCUBATOR;
    }
}
