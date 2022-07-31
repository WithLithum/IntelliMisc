package io.github.withlithum.intellimisc.block;

import io.github.withlithum.intellimisc.IntelliMisc;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class IntelliMiscBlocks {
    private IntelliMiscBlocks() {
        throw new IllegalStateException("No IntelliMiscItems instances for you!");
    }

    public static final Block PLYWOOD_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.5f, 4.0f)
            .sounds(BlockSoundGroup.WOOD));

    public static void registerBlocks() {
        IntelliMisc.LOGGER.info("Registering blocks");
        Registry.register(Registry.BLOCK, IntelliMisc.id("plywood_planks"), PLYWOOD_PLANKS);

        IntelliMisc.LOGGER.info("Registering flammable block information");
        FlammableBlockRegistry.getDefaultInstance().add(PLYWOOD_PLANKS, 1, 1);
    }

    public static void registerBlockItems() {
        IntelliMisc.LOGGER.info("Registering block items");
        registerBlockItem(PLYWOOD_PLANKS, IntelliMisc.id("plywood_planks"), ItemGroup.BUILDING_BLOCKS);
    }

    public static void registerBlockItem(Block block, Identifier id, ItemGroup group) {
        IntelliMisc.LOGGER.debug("Registering block item for " + id.toString());
        Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(group)));
    }
}
