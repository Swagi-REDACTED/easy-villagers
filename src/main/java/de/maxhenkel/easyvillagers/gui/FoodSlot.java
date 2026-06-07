package de.maxhenkel.easyvillagers.gui;

import net.minecraft.world.Container;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class FoodSlot extends Slot {
 
    public FoodSlot(Container inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public static int getFoodValue(ItemStack stack) {
        if (net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("villagerbreedingenhancements")) {
            net.minecraft.world.food.FoodProperties food = stack.get(net.minecraft.core.component.DataComponents.FOOD);
            if (food != null) {
                int value = Math.round(food.nutrition() * 0.8F);
                return Math.max(0, value);
            }
            return 0;
        }
        return Villager.FOOD_POINTS.getOrDefault(stack.getItem(), 0);
    }

    public static boolean isValid(ItemStack stack) {
        return getFoodValue(stack) > 0;
    }

}
