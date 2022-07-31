package io.github.withlithum.intellimisc.enchant;

import io.github.withlithum.intellimisc.IntelliMisc;
import io.github.withlithum.intellimisc.enchant.base.MeleeStatusEffectEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public final class IntelliMiscEnchants {
    private IntelliMiscEnchants() {}

    public static final MeleeStatusEffectEnchantment WITHERING = new MeleeStatusEffectEnchantment.Builder()
            .maxLevel(3)
            .rarity(Enchantment.Rarity.VERY_RARE)
            .effectLevelAmplifier(1)
            .effectDurationBase(15)
            .slot(EquipmentSlot.MAINHAND)
            .target(EnchantmentTarget.WEAPON)
            .treasure()
            .build();

    public static void registerEnchants() {
        IntelliMisc.LOGGER.info("Registering enchantments");
        Registry.register(Registry.ENCHANTMENT, IntelliMisc.id("withering"), WITHERING);
    }
}
