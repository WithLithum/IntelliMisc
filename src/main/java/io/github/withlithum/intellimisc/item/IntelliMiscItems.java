package io.github.withlithum.intellimisc.item;

import io.github.withlithum.intellimisc.IntelliMisc;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

/**
 * Defines/loads items for the IntelliMisc modification.
 */
public final class IntelliMiscItems {
    private IntelliMiscItems() {
        throw new IllegalStateException("No IntelliMiscItems instances for you!");
    }

    public static final Item RAW_PUFFERFISH = new Item(new FabricItemSettings()
            .group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder()
                    .hunger(2)
                    .saturationModifier(0.2f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 300, 3), 100f)
                    .build()));

    public static final Item SLIME_GEL = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public static void registerItems() {
        Log.info(LogCategory.LOG, "Registering items for IntelliMisc");
        Registry.register(Registry.ITEM, IntelliMisc.id("raw_pufferfish"), RAW_PUFFERFISH);
        Registry.register(Registry.ITEM, IntelliMisc.id("slime_gel"), SLIME_GEL);
    }
}
