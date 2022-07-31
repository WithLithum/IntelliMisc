package io.github.withlithum.intellimisc.enchant.base;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

/**
 * Represents an enchantment that is partially customisable via constructor.
 */
public class BaseEnchantment extends Enchantment {
    private final boolean isTreasureBackingField;
    private final boolean isCursedBackingField;

    private final int maxLevelBackingField;

    public BaseEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes,
                           boolean isTreasure, boolean isCursed, int maxLevel) {
        super(weight, type, slotTypes);

        this.isTreasureBackingField = isTreasure;
        this.isCursedBackingField = isCursed;
        this.maxLevelBackingField = maxLevel;
    }

    /**
     * Gets a value indicating whether this instance is considered a "curse" enchantment.
     * Curse enchantments are shown in red colour in tooltips of applied items.
     * @return {@code true} if this instance is cursed; otherwise, {@code false}.
     */
    @Override
    public boolean isCursed() {
        return isCursedBackingField;
    }

    /**
     * Gets a value indicating whether this instance is a treasure enchantment.
     * Treasure enchantments are not available on {@link net.minecraft.block.EnchantingTableBlock}.
     * @return {@code true} if this instance is treasure; otherwise, {@code false}.
     */
    @Override
    public boolean isTreasure() {
        return isTreasureBackingField;
    }

    @Override
    public int getMaxPower(int level) {
        return 1;
    }

    /**
     * Gets the maximum level of this instance.
     * @return The maximum level of this instance.
     */
    @Override
    public int getMaxLevel() {
        return maxLevelBackingField;
    }
}
