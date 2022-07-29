package io.github.withlithum.intellimisc.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IntelliBow extends net.minecraft.item.BowItem {
    public IntelliBow(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 150000;
    }
}
