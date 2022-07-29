package io.github.withlithum.intellimisc;

import io.github.withlithum.intellimisc.block.IntelliMiscBlocks;
import io.github.withlithum.intellimisc.item.IntelliMiscItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Defines the main initialisation type of this modification.
 */
public class IntelliMisc implements ModInitializer {
    @Override
    public void onInitialize() {
        Log.info(LogCategory.LOG, "IntelliMisc: Instantiated!");
        IntelliMiscItems.registerItems();
        IntelliMiscBlocks.registerBlocks();
        IntelliMiscBlocks.registerBlockItems();
    }

    public static final String NAMESPACE = "intellimisc";

    @Contract("_ -> new")
    public static @NotNull Identifier getIdentifier(String id) {
        return new Identifier(NAMESPACE, id);
    }
}
