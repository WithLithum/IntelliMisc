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
        Log.info(LogCategory.LOG, "IntelliMisc: Registering Blocks");
        Registry.register(Registry.BLOCK, IntelliMisc.getIdentifier("plywood_planks"), PLYWOOD_PLANKS);

        Log.info(LogCategory.LOG, "IntelliMisc: Registering flammables");
        FlammableBlockRegistry.getDefaultInstance().add(PLYWOOD_PLANKS, 1, 1);
    }

    public static void registerBlockItems() {
        Log.info(LogCategory.LOG, "IntelliMisc: Registering block items");
        registerBlockItem(PLYWOOD_PLANKS, IntelliMisc.getIdentifier("plywood_planks"), ItemGroup.BUILDING_BLOCKS);
    }

    public static void registerBlockItem(Block block, Identifier id, ItemGroup group) {
        Registry.register(Registry.ITEM, id, new BlockItem(block, new FabricItemSettings().group(group)));
    }
}
